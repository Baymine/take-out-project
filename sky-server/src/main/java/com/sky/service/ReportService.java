package com.sky.service;


import com.sky.vo.TurnoverReportVO;

import java.time.LocalDate;

/**
 *  营业额统计
 */
public interface ReportService {
    TurnoverReportVO getTurnoverStatistics(LocalDate begin, LocalDate end);
}
