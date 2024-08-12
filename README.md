# 도로명 주소 최신화

## 개발환경
Java 1.8

### 1. https://www.epost.go.kr/search/zipcode/areacdAddressDown.jsp 에서 우편번호 내려받기

![1](https://github.com/user-attachments/assets/9c40add8-d195-4cde-9d98-ba8fd895feea)

### 2. 적당한 곳에 압축을 풀고, 폴더에 프로젝트를 빌드해서 jar 파일 넣기

![2](https://github.com/user-attachments/assets/6af6839f-1ab1-4cff-8a64-b04dbcdf92e3)

### 3. 폴더를 터미널로 열고 jar 실행시키기

![3](https://github.com/user-attachments/assets/69cd9ed9-321e-4e32-a664-4db4f4175cf7)

### 4. 변환된 파일들 확인

![4](https://github.com/user-attachments/assets/af12272e-bc6e-465e-a09c-4175d9ff0e2c)

### 주의사항

각자 DB에서 사용하는 컬럼명은 AddressCsvFileWriter에서 셀프로 수정하고 빌드할 것

![image](https://github.com/user-attachments/assets/babafebe-e891-4c0c-b57b-26244ca1964b)

