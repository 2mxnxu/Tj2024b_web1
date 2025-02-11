<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="col-md-10 mx-auto col-lg-5">
        <form id="signupform" class="p-4 p-md-5 border rounded-3 bg-body-tertiary">
          <div class="form-floating mb-3">
          <h3>도서생성</h3>
          <hr/>
          <h6>도서명</h6>
            <input type="text" name="bname" class="form-control" id="floatingBname" placeholder="도서명">
          </div>
          
          <div class="form-floating mb-3">
          <h6>저자</h6>
            <input type="text" name="bwriter" class="form-control" id="floatingBwriter" placeholder="저자">
          </div>
          
          <div class="form-floating mb-3">
          <h6>출판사</h6>
            <input type="text" name="bpublisher" class="form-control" id="floatingBpublisher" placeholder="계정비밀번호 확인">
            
          </div>
        
        
          <button class="w-100 btn btn-lg btn-primary" type="button" onclick="onAdd()">Submit</button>
         
        </form>
      </div>
<script src="/bookservice/js/books/write.js" type="text/javascript" ></script>
</body>
</html>