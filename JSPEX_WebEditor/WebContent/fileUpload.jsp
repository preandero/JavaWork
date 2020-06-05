<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- cos 라이브러리 --%>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.FileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>

<%-- parameter 값들, file 값들 추출 --%>
<%@ page import="java.util.Enumeration" %>

<%--File 객체 --%>
<%@ page import="java.io.File" %>