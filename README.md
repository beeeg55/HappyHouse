# HappyHouse_Final



* 개요: 주택 거래정보 조회 사이트

* 사용기술: HTML, CSS, JavaScript, Jquery, MySQL/ Bootstrap, Google GeoCoding API, GmailSender, SpringBoot

* 팀원: 김단비, 오성


### 1. 프로젝트 구조

* Java Resources (Back_End)

  * src

    * controller

      * HappyMapController.java
      * UserController.java
      * BizInfoController.java
      * NoticeController.java
      * ScreeningController.java
      * SitemapController.java
      * SmartSearchController.java

    * model.dto

      * HappyDealDto.java
      * HouseInfoDto.java
      * SidoGugunCodeDto.java
      * User.java
      * UserInterestDto.java
      * Hospital.java
      * HospitalDto.java
      * NoticeDto.java
      * ScreeningDto.java
      * BizCategoryDto.java
      * BizInfoDto.java

    * model.dao

      * HouseMapDao.java
      * HouseMapDaoImpl.java
      * UserDAOImpl.java
      * HospitalDao.java
      * HospitalDaoImpl.java
      * NoticeDao.java
      * NoticeDaoImpl.java
      * ScreeningDao.java
      * BizInfoDao.java
      * BizInfoDaoImpl.java

    * service

      * HouseMapServiceImpl.java
      * HouseMapService.java
      * UserServiceImpl.java
      * HospitalService.java
      * HospitalServiceImpl.java
      * ScreeningService.java
      * ScreeningServiceImpl.java
      * BizInfoService.java
      * BizInfoServiceImpl.java
      * NoticeService.java
      * NoticeServiceImpl.java

    * util

      * DBUtil.java
      * GMailSender.java
      * PageInfo.java

      

* WebContent (Front_End)

  * index.jsp : 메인 페이지 

  * 01_search : 실거래가 검색 

    * search.jsp

  * 02_surround: 안심정보/선별진료소

    * surround.jsp

  * 03_interest : 관심지역 주변상권 조회 

    * interest.jsp

  * 04_notice : 공지사항 

    * notice.jsp
    * noticeDetail.jsp
    
  * 05_userlist : 회원 관리 

    * userlist.jsp

  * 06_sitemap : 사이트맵

    * sitemap.jsp
    
  * 07_smartsearch : 스마트 조회 

    * smartsearch.jsp
    

  * common

    * topbar.jsp
    * bottombar.jsp
    * common.css
    * map.css

  * img

  * META-INF

    * [happyhouse_allSchema_v2.2_updateBiz.sql](/uploads/6659637b77c7a178f20894c331491810/happyhouse_allSchema_v2.2_updateBiz.sql)

* WEB-INF

  

<hr/>



### 2. 테이블 목록

> **HappyHouse ERD 다운로드 ([1._HappyHouse_ERD.mwb](/uploads/dc8fa8b19c2cb65dc3dffeeae5629f2a/1._HappyHouse_DR_다이어그램.mwb))**



- housedeal (주택 거래 정보)

- houseinfo (주택 정보)

- baseaddress (위치 정보)

- sidocode (시/도 정보)

- guguncode (구/군 정보)

- dongcode (동 정보)

- hospital (안심병원 정보)

  | 컬럼명  | 논리키    | DataType | 키/ 특징                           | Default/Expression |
  | ------- | --------- | -------- | ---------------------------------- | ------------------ |
  | no      | 행 번호   | INT      | PK \| not null \| (Auto Increment) |                    |
  | sido    | 시 이름   | TEXT     |                                    |                    |
  | gugun   | 구/군이름 | TEXT     |                                    |                    |
  | name    | 병원명    | TEXT     |                                    |                    |
  | address | 주소      | TEXT     |                                    |                    |
  | type    | 병원종류  | TEXT     |                                    |                    |
  | tel     | 번호      | TEXT     |                                    |                    |

- screening_center (선별진료소 정보)

  | 럼명         | 논리키                  | DataType | 키/ 특징                           | Default/Expression |
  | ------------ | ----------------------- | -------- | ---------------------------------- | ------------------ |
  | no           | 행 번호                 | INT      | PK \| not null \| (Auto Increment) |                    |
  | possible     | 검사채취 <br />가능여부 | TEXT     |                                    |                    |
  | gugun        | 구/군이름               | TEXT     |                                    |                    |
  | name         | 병원명                  | TEXT     |                                    |                    |
  | weektime     | 주중                    | TEXT     |                                    |                    |
  | sattime      | 주말                    | TEXT     |                                    |                    |
  | Holiday time | 공휴일                  | TEXT     |                                    |                    |
  | tel          | 전화번호                | TEXT     |                                    |                    |

- user (사용자)

  | 컬럼명   | 논리키                                                       | DataType    | 키설정         | Default/Expression |
  | -------- | ------------------------------------------------------------ | ----------- | -------------- | ------------------ |
  | userid   | 사용자아이디                                                 | VARCHAR(16) | PK \| not null |                    |
  | username | 사용자이름                                                   | VARCHAR(20) | not null       |                    |
  | userpwd  | 사용자비밀번호                                               | VARCHAR(16) | not null       |                    |
  | email    | 이메일                                                       | VARCHAR(50) |                | NULL               |
  | joindate | 가입일자                                                     | TIMESTAMP   | not null       | CURRENT_TIMESTAMP  |
  | useage   | 사용자 등급<br />* 0:일반사용자,-1:탈퇴회원,<br />100: 관리자 | INT         | not null       |                    |

  

- user_interest (사용자 관심지역 테이블)

  | 컬럼명   | 논리키                            | DataType    | 키/ 특징                           | Default/Expression |
  | -------- | --------------------------------- | ----------- | ---------------------------------- | ------------------ |
  | num      | 행 번호                           | INT         | PK \| not null \| (Auto Increment) |                    |
  | id       | 사용자 아이디                     | VARCHAR(45) | 외래키 from user (userid)          |                    |
  | interest | 사용자 관심지역<br />`(시_군_구)` | VARCHAR(45) | (Unique)                           |                    |

  

  *) user_interest 예제

  1. | num  | id    | interest               |
     | ---- | ----- | ---------------------- |
     | 1    | admin | `서울시_관악구_신림동` |
     | 2    | admin | `서울시_관악구_봉천동` |
     | 3    | user1 | `서울시_중구_필동3가`  |

  

- large_category (상권정보 대분류)

  | 컬럼명     | 논리키      | DataType | 키/ 특징       | Default/Expression |
  | ---------- | ----------- | -------- | -------------- | ------------------ |
  | large_code | 대분류 코드 | TEXT     | PK \| not null | NULL               |
  | large_name | 대분류 이름 | TEXT     |                | NULL               |

- mid_category (상권정보 중분류)

  | 컬럼명   | 논리키      | DataType | 키/ 특징       | Default/Expression |
  | -------- | ----------- | -------- | -------------- | ------------------ |
  | mid_code | 중분류 코드 | TEXT     | PK \| not null | NULL               |
  | mid_name | 중분류 이름 | TEXT     |                | NULL               |

- small_category (상권정보 소분류)

  | 컬럼명     | 논리키      | DataType | 키/ 특징 | Default/Expression |
  | ---------- | ----------- | -------- | -------- | ------------------ |
  | large_name | 대분류 이름 | TEXT     |          | NULL               |
  | mid_name   | 즁분류 이름 | TEXT     |          | NULL               |
  | small_code | 소분류 코드 | TEXT     |          | NULL               |
  | small_name | 소분류 이름 | TEXT     |          | NULL               |

- bizinfo (상권정보)

  | 컬럼명      | 논리키     | DataType | 키/ 특징       | Default/Expression |
  | ----------- | ---------- | -------- | -------------- | ------------------ |
  | biz_id      | 상권번호   | TEXT     | PK \| not null | NULL               |
  | biz_name    | 상호명     | TEXT     |                | NULL               |
  | branch_name | 지점명     | TEXT     |                | NULL               |
  | std_code    | 업종코드   | TEXT     |                | NULL               |
  | std_name    | 업종명     | TEXT     |                | NULL               |
  | dong_name   | 동 이름    | TEXT     |                | NULL               |
  | floor       | 층수       | TEXT     |                | NULL               |
  | ho          | 호수       | TEXT     |                | NULL               |
  | lng         | 경도       | TEXT     |                | NULL               |
  | lat         | 위도       | TEXT     |                | NULL               |
  | small_code  | 소분류코드 | TEXT     |                | NULL               |



- news/ notice (최신뉴스/공지사항)

  | 컬럼명 | 논리키   | DataType      | 키/ 특징                           | Default/Expression |
  | ------ | -------- | ------------- | ---------------------------------- | ------------------ |
  | id     | 행 번호  | INT           | PK \| not null \| (Auto Increment) |                    |
  | title  | 글제목   | VARCHAR(45)   | not null                           |                    |
  | des    | 글내용   | VARCHAR(1000) | not null                           |                    |
  | date   | 작성일자 | TIMESTAMP     | not null                           | CURRENT_TIMESTAMP  |







<hr/>

### 3. 구현 화면





+ 메인 페이지

  <img src ="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EB%A9%94%EC%9D%B8%ED%8E%98%EC%9D%B4%EC%A7%801.png?raw=true" width="1000px" />
  <img src ="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EB%A9%94%EC%9D%B8%ED%8E%98%EC%9D%B4%EC%A7%802.png?raw=true" />

  + **주택** **검색**: **주택 검색 결과를 지도에 마킹해 보여줍니다.**

    + 지역으로 검색

      ![ezgif com-video-to-gif](https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EC%8B%A4%EA%B1%B0%EB%9E%98%EA%B0%80%20%EC%A7%80%EC%97%AD%EC%9C%BC%EB%A1%9C%20%EA%B2%80%EC%83%89.gif?raw=true)

    + 이름으로 검색

      ![ezgif com-video-to-gif](https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EC%8B%A4%EA%B1%B0%EB%9E%98%EA%B0%80%20%EC%9D%B4%EB%A6%84%EC%9C%BC%EB%A1%9C%20%EA%B2%80%EC%83%89.gif?raw=true)


​      

   





+ 실거래가 검색, 결과

  + 기본화면

    <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EC%8B%A4%EA%B1%B0%EB%9E%98%EA%B0%80%20%EA%B2%80%EC%83%89.png?raw=true" width="1000px"/>

    

  + **주택 검색: 주택 검색 정보를 테이블, 지도에 나타냅니다.**

    ![ezgif com-video-to-gif](https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EC%8B%A4%EA%B1%B0%EB%9E%98%EA%B0%80%20%EC%A3%BC%ED%83%9D%20%EA%B2%80%EC%83%89.gif?raw=true)

    

  + **상세 거래정보 조회:   지도에서 선택한 주택의 거래정보를 보여줍니다.**

    ![ezgif com-video-to-gif-2](https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EC%8B%A4%EA%B1%B0%EB%9E%98%EA%B0%80%20%EC%83%81%EC%84%B8%20%EA%B1%B0%EB%9E%98%EC%A0%95%EB%B3%B4%20%EC%A1%B0%ED%9A%8C.gif?raw=true)

  

+ 안심병원/ 선별진료소 정보 조회

  + 카테고리 (시/도, 구/군)

    <img src="https://lab.ssafy.com/jiunlee97/test/uploads/b409b7d72a2340521d51f0598a670f2f/%EC%95%88%EC%8B%AC%EB%B3%91%EC%9B%90_%EC%84%A0%EB%B3%84%EC%A7%84%EB%A3%8C%EC%86%8C_%EC%B9%B4%ED%85%8C%EA%B3%A0%EB%A6%AC.png"  />

    

  + 시/도, 구/군명으로 검색

    <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EC%95%88%EC%8B%AC%EB%B3%91%EC%9B%90,%20%EC%84%A0%EB%B3%84%EC%A7%84%EB%A3%8C%EC%86%8C.png?raw=true" width="1000px" />



+ **관심지역 설정/  관심지역 상권정보 조회**

  + 관심지역

    <img src ="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EA%B4%80%EC%8B%AC%EC%A7%80%EC%97%AD.png?raw=true">

    

  + 관심지역 추가 & 결과

    ![ezgif com-video-to-gif](https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EA%B4%80%EC%8B%AC%EC%A7%80%EC%97%AD%20%EC%B6%94%EA%B0%80.gif?raw=true)

    

  + 관심지역 삭제

    + 삭제 버튼으로 삭제

      ![ezgif com-video-to-gif](https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/산출물/스크린샷/관심지역%20삭제.gif?raw=true)

    + 삭제전 화면

      <img src="https://lab.ssafy.com/jiunlee97/test/uploads/0534aa9776b68fcc0b49967db4831d2e/%EA%B4%80%EC%8B%AC%EC%A7%80%EC%97%AD_%EC%82%AD%EC%A0%9C%EC%A0%84.JPG" width="1000px" />

      

    + 삭제 확인 팝업창

      <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EA%B4%80%EC%8B%AC%EC%A7%80%EC%97%AD%20%EC%82%AD%EC%A0%9C%20%ED%8C%9D%EC%97%85%EC%B0%BD.png?raw=true" />

      

    + 삭제후 화면

      <img src="https://lab.ssafy.com/jiunlee97/test/uploads/7d8d0a2a6769f4106ee6b21a619090dc/%EA%B4%80%EC%8B%AC%EC%A7%80%EC%97%AD_%EC%82%AD%EC%A0%9C%EC%99%84%EB%A3%8C.JPG" width="1000px" />



  + 상권정보 카테고리로 조회

    + 카테고리 선택창

      ​	<img src="https://lab.ssafy.com/jiunlee97/test/uploads/7ae6cadcf3f51b119096de86e903d8bd/%EA%B4%80%EC%8B%AC%EC%A7%80%EC%97%AD_%EC%B9%B4%ED%85%8C%EA%B3%A0%EB%A6%AC.png" />

      

    + 조회 결과

      <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EA%B4%80%EC%8B%AC%EC%A7%80%EC%97%AD%20%EA%B2%B0%EA%B3%BC.png?raw=true" width="1000px" />

      
+ 스마트 검색: 원하는 지역과 가격 범위를 선택하여 매물 검색기능을 제공합니다.
  
    ![ezgif com-video-to-gif-2](https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EC%8A%A4%EB%A7%88%ED%8A%B8%EC%A1%B0%ED%9A%8C.gif?raw=true)
      


+ 공지사항/최신 뉴스

  + 화면

    <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EA%B3%B5%EC%A7%80%EC%82%AC%ED%95%AD.png?raw=true" >

  + 조회

    <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EA%B3%B5%EC%A7%80%EC%82%AC%ED%95%AD%20%EC%83%81%EC%84%B8.png?raw=true" >

   + 글 작성

    <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EA%B3%B5%EC%A7%80%EC%82%AC%ED%95%AD%20%EA%B8%80%20%EC%9E%91%EC%84%B1.png?raw=true" >
    

+ 회원관리

  + 관리자 화면: 관리자 계정에게만 회원관리 버튼이 보여집니다. & 조회

    + 전체조회: 모든 일반 회원 정보를 조회합니다.

    <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%ED%9A%8C%EC%9B%90%EA%B4%80%EB%A6%AC%20%EC%A0%84%EC%B2%B4%EC%A1%B0%ED%9A%8C.png?raw=true" >

      

    + 특정회원조회 : 이름으로 회원을 검색합니다.

      ![ezgif com-video-to-gif-4](https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%ED%8A%B9%EC%A0%95%ED%9A%8C%EC%9B%90%20%EC%A1%B0%ED%9A%8C.gif?raw=true)

      

    + 상세정보 조회: 선택한 회원의 정보를 조회할 수 있습니다. (마우스 클릭)

      ![ezgif com-video-to-gif](https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%ED%9A%8C%EC%9B%90%20%EC%83%81%EC%84%B8%EC%A0%95%EB%B3%B4%20%EC%A1%B0%ED%9A%8C.gif?raw=true)

      

    

    ​	

  + 수정: 회원정보를 수정합니다.

    + 수정화면

      <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%ED%9A%8C%EC%9B%90%EC%A0%95%EB%B3%B4%20%EC%88%98%EC%A0%95.png?raw=true" width="1000px">

      

    + 수정결과

      ![ezgif com-video-to-gif](https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%ED%9A%8C%EC%9B%90%EC%A0%95%EB%B3%B4%20%EC%88%98%EC%A0%95%20%EA%B2%B0%EA%B3%BC.gif?raw=true)

    

    

    - 등록: 관리자가 회원을 등록합니다.

      - 등록 화면

      ![ezgif com-video-to-gif-4](https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%ED%9A%8C%EC%9B%90%EB%93%B1%EB%A1%9D.gif?raw=true)

      

  + 삭제: 삭제버튼을 통해 회원 정보를 삭제합니다. 

    + 삭제 화면 

      <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%ED%9A%8C%EC%9B%90%EC%A0%95%EB%B3%B4%20%EC%82%AD%EC%A0%9C.png?raw=true" width="1000px">

  

+ 회원가입

  + 가입 화면: 페이지 상단 회원가입 버튼을 통해 가입을 진행합니다.

    <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%ED%9A%8C%EC%9B%90%20%EA%B0%80%EC%9E%85.png?raw=true" width="1000px">




+ 로그인/로그아웃

  + 로그인

    + 로그인 화면

      <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EB%A1%9C%EA%B7%B8%EC%9D%B8.png?raw=true" width="1000px">

      

    + 로그인 결과 : 로그인 후 메인화면으로 이동합니다. 

      * 기존 상단 버튼(회원가입, 로그인) 버튼이 회원정보, 로그아웃 으로 변경됩니다.

      + 기존 topbar

        <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EA%B8%B0%EC%A1%B4%20topbar.png?raw=true"  witdh="1000px">

        

        

      + 변경 topbar

        + 일반사용자

          <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EC%9D%BC%EB%B0%98%EC%82%AC%EC%9A%A9%EC%9E%90%20topbar.png?raw=true" width="1000px">

        + 관리자

          <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EA%B4%80%EB%A6%AC%EC%9E%90%20topbar.png?raw=true" width="1000px">

        + 로그인 실패

          <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EB%A1%9C%EA%B7%B8%EC%9D%B8%20%EC%8B%A4%ED%8C%A8.png?raw=true" width="1000px">

          

        

    

  

  + 로그아웃

    + 안내메시지

      <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EB%A1%9C%EA%B7%B8%EC%95%84%EC%9B%83%20%EC%95%88%EB%82%B4%EB%A9%94%EC%84%B8%EC%A7%80.png?raw=true" width="1000px">

      

    + 결과 화면 (세션 소멸)

      ![ezgif com-video-to-gif](https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EB%A1%9C%EA%B7%B8%EC%95%84%EC%9B%83.gif?raw=true)

      

  + 내 정보: 페이지 상단 [회원정보] 버튼을 사용해 내 정보를 조회/수정/삭제 할 수있습니다.

    + 조회 & 수정

      ![ezgif com-video-to-gif-2](https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EB%82%B4%EC%A0%95%EB%B3%B4%20%EC%88%98%EC%A0%95.gif?raw=true)

    + 탈퇴

      ![ezgif com-video-to-gif-3](https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%ED%9A%8C%EC%9B%90%20%ED%83%88%ED%87%B4.gif?raw=true)

      

      


​    
​      


​      

  

+ 비밀번호 찾기: 이메일로 임시 비밀번호를 발급합니다.

  + 화면

    +   입력폼에 입력한 아이디가 가입 아이디와 일치하면 임시 비밀번호를 이메일로 발급합니다.				

    

    ![ezgif com-video-to-gif-3](https://user-images.githubusercontent.com/44195636/95738117-b2a13f00-0cc3-11eb-8edd-94e2d5bb3301.gif)






+ 사이트맵/메뉴구성

  + 메뉴구성: 실거래가 조회, 주변탐방, 관심지역, 공지사항, 사이트맵

    <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EB%A9%94%EB%89%B4.png?raw=true" width=1000px>

    

  + 사이트맵: 전체 사이트 구성을 보여주고 클릭 시 Navigation 기능을 제공합니다. 
  
    <img src="https://github.com/beeeg55/HappyHouse/blob/master/HappyHouse_Final/res/%EC%82%B0%EC%B6%9C%EB%AC%BC/%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7/%EC%82%AC%EC%9D%B4%ED%8A%B8%EB%A7%B5.png?raw=true" width=1000px >

    

<hr/>





