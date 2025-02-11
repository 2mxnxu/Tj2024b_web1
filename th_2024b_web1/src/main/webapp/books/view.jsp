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
          <h3>도서상세정보</h3>
          <hr/>
          <a>도서번호 :</a> <a>28 </a> 
          </div>
          
          <div class="form-floating mb-3">
          <a>도서명 :</a><a> 나는</a>
             </div>
          
          <div class="form-floating mb-3">
          <a>저자 :</a><a> 유재석</a>
             </div>
          
          <div class="form-floating mb-3">
          <a>출판사 : </a> <a>가나다</a>
          </div>
          
          <div class="form-floating mb-3">
          <a>생성일 : </a> <a>2025-02-10 12:09:11</a>
          </div>
          
          <div class="form-floating mb-3">
          <a>수정일 : </a> <a>2025-02-10 12:09:11</a>
          </div>
        
                <button class="w-100 btn btn-lg btn-primary" type="button" onclick="location.href='book.jsp' ">뒤로가기</button>
              <br/><br/>  
          <button class="w-100 btn btn-lg btn-primary" type="button" onclick="location.href='update.jsp'">수정</button>
          <br/><br/>
          <button class="w-100 btn btn-lg btn-primary" type="button" onclick="onDelete() ">삭제</button>
         
        </form>
      </div>
<script src="/bookservice/js/books/view.js" type="text/javascript" ></script>
</body>
</html>