<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="b" tagdir="/WEB-INF/tags/board"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/icon/css/all.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

<title>Insert title here</title>
</head>
<body>
	<b:navBar></b:navBar>

	<!-- .container>.row>.col>h1{회원 가입} -->
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>회원 가입</h1>

				<c:if test="${not empty alertMessage}">
					<div class="alert alert-warning">${alertMessage }</div>
				</c:if>

				<!-- form>.form-group*4>label[for=input$]+input.form-control#input$[required]^button.btn.btn-outline-primary{가입} -->
				 <form method="post">
				<div class="form-group">
				 <label for="input1">아이디</label>
				<!-- .input-group>.input-group-append>button.btn.btn-secondary#idCheckButton{중복확인} -->
				<div class="input-group">
				 <input type="text" class="form-control" id="input1" required name="id" value="${member.id }">
				<div class="input-group-append">
				 <button class="btn btn-secondary" id="idCheckButton" type="button">중복확인</button>
				   </div>
				  </div>
				<!-- small.form-text#idCheckMessage -->
				<small class="form-text" id="idCheckMessage"></small>
				 </div>
				<div class="form-group">
				 <label for="input2">패스워드</label> <input type="password" class="form-control" id="input2" required name="password" value="${member.password }">
				  </div>
				<div class="form-group">
				 <label for="input6">패스워드 확인</label> <input type="password" class="form-control" id="input6" required>
				  </div>
				<div class="form-group">
				 <label for="input5">닉네임</label>
				<div class="input-group">
				 <input type="text" class="form-control" id="input5" required name="nickName" value="${member.nickName }">
				<div class="input-group-append">
				 <button class="btn btn-secondary" id="nicCheckButton" type="button">중복확인</button>
				   </div>
				  </div>
				<!-- small.form-text#idCheckMessage -->
				 <small class="form-text" id="nicCheckMessage"></small>
				  </div>
				<div class="form-group">
				 <label for="input3">이메일</label> <input type="email" class="form-control" id="input3" required name="email" value="${member.email }">
				  </div>
				<div class="form-group">
				 <label for="input4">주소</label> <input type="text" class="form-control" id="input4" required name="address" value="${member.address }">
				  </div>
				 <button class="btn btn-outline-primary" id="submitButton1">가입</button>
				 </form>
			</div>
		</div>
	</div>


	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF" crossorigin="anonymous"></script>

	<script>
		$(document).ready(	function() {
		// 필요요소 선택
		const passwordInput = $("#input2");
		const passwordConfirmInput = $("#input6");
		const submitButton = $("#submitButton1");

		// 가입 버튼 활성화 조건 변수
		let idAble = false;
		let passwordCheck = false;
		let nicAble = false;

		// 가입 버튼 활성화 메소드
		let enableSubmit = function() {
			if (idAble && passwordCheck) {
				submitButton.removeAttr("disabled");
			} else {
				submitButton.attr("disabled", true);
			}
		}
		// 컨텐츠패스
		const appRoot = '${pageContext.request.contextPath}';

		// 아이디 중복 확인 -> input 요소에 입력된 값을 서버전송 후
		// 응답받은 값에 따라서
		// 1> 가입 버튼활성화 혹은 비활성화
		// 2> 사용가능 또는 불가능 메세지 출력

		$("#idCheckButton").click(function() {
			$("#idCeckButton").attr("disabled", true);
										
		const idValue = $("#input1").val().trim();
	
		// 아이디 input에 입력안되었을 경우 더 이상 진행하지 않고
		// 아이디 입력하라는 메세지 출력
		if (idValue === "") {
			$("#idCheckMessage").text("아이디를 입력해주세요.")							
			.removeClass("text-primary text-danger")			
			.addClass("text-warning");										
			
			return;
		}

		$.ajax({
			url : appRoot + "/member/idcheck",
	
			data : {									
				id : idValue
			},											
	
			success : function(data) {						
				switch (data) {

				case "able":	
				// 사용가능할 때
										
				$("#idCheckMessage").text("사용 가능한 아이디 입니다.")
				.removeClass("text-danger text-warning").addClass("text-primary");
											
				// 가입 버튼 활성화 조건 추가								
				idAble = true;									
					break;
							
				case "unable":				
				// 사용불가능할 때
														
				$("#idCheckMessage").text("이미 있는 아이디 입니다.")
				.removeClass("text-warning text-primary").addClass("text-danger");
				
				// 가입 버튼 비활성화 조건 추가
				idAble = false;
					break;

				default:
					break;
				}
			},
			
			complete : function() {
				
				endableSubmit(); // 조건이 충족되었을때만 가입 버튼 활성화
					$("#idCheckMessage").removeAttr("disabled");
				}
			});
		});
/*		
		// 닉네임 중복 확인
		$("#nicCheckButton").click(function() {
			$("#nicCheckButton").attr("disabled", true);
										
		const nicValue = $("#input5").val().trim();
		
		if (nicValue === "") {
			$("#nicCheckMessage").text("닉네임을 입력해주세요.")							
			.removeClass("text-primary text-danger")			
			.addClass("text-warning");										
			
			return;
		}

		$.ajax({
			url : appRoot + "/member/niccheck",
			
			data : {									
				nicName : nicValue
			},											
			
			success : function(data) {							
				switch (data) {
										
				case "able":	
				// 사용가능할 때
										
				$("#nicCheckMessage").text("사용 가능한 닉네임 입니다.")
				.removeClass("text-danger text-warning").addClass("text-primary");
											
				// 가입 버튼 활성화 조건 추가								
				nicAble = true;									
					break;
							
				case "unable":				
				// 사용불가능할 때
														
				$("#nicCheckMessage").text("중복된 닉네임 입니다.")
				.removeClass("text-warning text-primary").addClass("text-danger");
				
				// 가입 버튼 비활성화 조건 추가
				nicAble = false;
					break;

				default:
					break;
				}
			},
			
			complete : function() {
				
				endableSubmit(); // 조건이 충족되었을때만 가입 버튼 활성화
				
				$("#nicCheckMessage").removeAttr("disabled");
				}
			});
//		*/
		//두 개의 인풋요소 값이 같을 때만 submit 버튼 활성
		//아닐 경우 비활성
		const confirmFunction = function() {		
		const passwordValue = passwordInput.val();
		const passwordConfirmValue = passwordConfirmInput.val();

			if (passwordValue === passwordConfirmValue) {
				//	submitButton.removeAttr("disabled");
				passwordCheck = true;
			} else {
				//	submitButton.attr("disabled", true);
				passwordCheck = false;	
			}		
			endableSubmit();
		};
		
		submitButton.attr("disabled", true);
		
		passwordInput.keyup(confirmFunction);							
		
		passwordConfirmInput.keyup(confirmFunction);
		
	});
	</script>

</body>
</html>









