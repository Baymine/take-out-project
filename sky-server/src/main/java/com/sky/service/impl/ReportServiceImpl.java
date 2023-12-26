package com.sky.service.impl;

import com.sky.entity.Orders;
import com.sky.mapper.OrderMapper;
import com.sky.service.ReportService;
import com.sky.vo.TurnoverReportVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Slf4j
public class ReportServiceImpl implements ReportService {
    @Autowired
    private OrderMapper orderMapper;

    /**
     *  营业额统计
     * @param begin
     * @param end
     * @return
     */
    @Override
    public TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end) {
        List<LocalDate> dateList = new ArrayList<>();

        dateList.add(begin);
        while(!begin.equals(end)){
            // 计算指定日期的后一天
            begin = begin.plusDays(1);
            dateList.add(begin);
        }

        List<Double> trunoverList = new ArrayList<>();
        for (LocalDate date : dateList) {
            // date当天，状态为“已完成”的订单的数量
            LocalDateTime beginTime = LocalDateTime.of(date, LocalTime.MIN);
            LocalDateTime endTime = LocalDateTime.of(date, LocalTime.MAX);

            HashMap map = new HashMap<>();
            map.put("beginTime", beginTime);
            map.put("endTime", endTime);
            map.put("status", Orders.COMPLETED);

            Double turnover = orderMapper.sumByMap(map);
            turnover = turnover == null ? 0.0 : turnover;
            trunoverList.add(turnover);
        }

        return TurnoverReportVO.builder().
                dateList(StringUtils.join(dateList, ","))
                .turnoverList(StringUtils.join(trunoverList, ","))
                .build();
    }
}
