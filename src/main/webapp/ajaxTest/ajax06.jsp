<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="<%= request.getContextPath() %>/resource/css/icon/css/all.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<title>Insert title here</title>
<script>
$(document).ready(function() {
  const appRoot = "${pageContext.request.contextPath}";
  $("#btn01").click(function() {
	$.ajax({
	  url : appRoot + "/cont16/met01",
	  success : function (data) {
	    console.log(data);
	  }
	});    
  });
  
  $("#btn02").click(function() {
    $.ajax({
      url : appRoot + "/cont16/met02",
      success : function (data) {
        console.log(data); // string data
        
        let obj = JSON.parse(data); // js object
        console.log(obj);
        console.log(obj.contactName);
        console.log(obj.customerName);
      }
    })
  });
  
  $("#btn03").click(function() {
    $.ajax({
      url : appRoot + "/cont16/met03",
      success : function(data) {
        console.log(data);
        console.log(data.contactName);
        console.log(data.customerName);
      }
    });
  });
  
  $("#btn04").click(function() {
	$.ajax({
		url : appRoot + "/cont16/met04"	,
		success : function(data) {
			console.log(data.id);
			console.log(data.lname);
			console.log(data.fname);
		} 
	});
  });
  
  $("#btn05").click(function() {
	$.ajax({
		url : appRoot + "/cont16/met05",
		success : function(data) {
			console.log(data);
			console.log(data.id);
			console.log(data.password);
			console.log(data.address);
			console.log(data.email);
		}
	 });
  });
  
  $("#btn06").click(function() {
	$.ajax({
		url : appRoot + "/cont16/met06",
		success : function(data) {
			console.log(data);
			console.log(data.title);
			console.log(data.content);
			console.log(data.writer);
			console.log(data.customInserted);
		}
	});
 });
  
  $("#btn07").click(function() {
	    $.ajax({
	      url : appRoot + "/cont16/met07",
	      success : function(data) {
	        console.log(data);
	        
	        for (let i = 0; i < data.length; i++) {
	          console.log(data[i].title);
	        }
	      }
	  });
   });
  
  $("#btn08").click(function() {
	 $.ajax({
		url : appRoot + "/cont16/met08",
		success : function(data) {
			for(let i = 0; i< data.length; i++){
			console.log(data[i].nickName);	
			}
		}
	 });
	});
  
});
</script>

</head>
<body>
<button id="btn08">/cont16/met08 3개의 Member 응답 AND Member들의 닉네임 반복문 사용해서 출력</button> <br>
<button id="btn07">/cont16/met07 3개의 Board 응답</button> <br>
<button id="btn06">/cont16/met06 하나의 Board 게시물 응답 (json) 받고 각 프로퍼티 출력</button> <br>
<button id="btn05">/cont16/met04 하나의 Member 응답 (json)</button> <br>
<button id="btn04">/cont16/met04 json data 응답 - 자동 변환</button> <br>
<button id="btn03">/cont16/met03 json data 응답 - 자동 변환</button> <br>
<button id="btn02">/cont16/met02 json data 응답</button> <br>
<button id="btn01">/cont16/met01 string data 응답</button> <br>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

</body>
</html>








