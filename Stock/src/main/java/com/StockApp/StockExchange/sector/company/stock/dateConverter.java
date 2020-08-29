//package com.StockApp.StockExchange.sector.company.stock;
//
//import javax.persistence.AttributeConverter;
//import java.sql.Timestamp;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Date;
//public class dateConverter implements AttributeConverter < LocalDateTime, Timestamp > {
// 
//public Date convertToDatabaseColumn(LocalDate attribute) {
//  return attribute != null ? Date.valueOf(attribute) : null;
// }
// @Override
// public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
//  return dbData != null ? dbData.toLocalDateTime() : null;
// }
//}
