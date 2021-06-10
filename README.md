# wherehaveubeen

## specification 
- language : java 
- framework : spring boot 
- db : mysql 
- map api : google or naver 
- login api : kakao, naver 


## function 
- upload photos 
- upload contents, tag locations, invite friends 
- spot where you have been on the map 
- login via api 

## deadline 
by July 31st 2021

## weekely 
commit to own branch by every Weds 
merge to main on Sat

## how to git
### 새로 시작하는 경우

새로 시작하는 경우 자신의 브랜치를 먼저 생성해야 합니다. 브랜치란 다른 사람의 코드에 영향을 주지 않는 일종의 독립적인 코드 저장 공간입니다.
브랜치를 생성하고 웹 상의 원격 저장소(깃허브)에 작업물을 업로드 하는 방법은 다음과 같습니다.

1. 저장소를 복제합니다.
    ```
    $ git clone https://github.com/eunmik/wherehaveubeen.git
    ```

2. 자신의 브랜치를 생성합니다.
    ```
    $ cd algorithm-study
    $ git branch <내 브랜치>
    ```

3. 새로 생성한 브랜치로 이동합니다.
    ```
    $ git checkout <내 브랜치>
    ```

4. 현재 브랜치가 새로 생성한 브랜치인지 확인합니다.
    ```
    $ git branch -v
    * <내 브랜치> ...
      main ...
    ```

5. 자신의 디렉터리에 파일을 업로드하고 commit & push 합니다.
    ```
    $ git add <업로드할 디렉터리 및 파일>
    $ git commit -m "<작업 내용>"
    $ git push origin <내 브랜치>
    ```


### 이미 내 브랜치가 존재하는 경우

이미 내 브랜치가 존재하는 경우 `git clone` 시 `-b` 옵션으로 특정 브랜치를 명시해 가져오거나 `checkout -t` 옵션으로 다른 브랜치를 로컬 저장소로 가져올 수 있습니다.

1. 저장소를 복제합니다 (`-b` 옵션 생략 시 `main` 브랜치를 가져옴).
    ```
    $ git clone https://github.com/eunmik/wherehaveubeen.git
    ```

2. 원격 저장소에 있는 브랜치 목록을 확인합니다.
    ```
    $ git branch -r
    origin/HEAD -> origin/main
    origin/...
    origin/...
    origin/<내 브랜치>
    origin/...
    ```

3. 명시한 브랜치를 로컬 저장소로 가져옵니다.
    ```
    $ git checkout -t origin/<내 브랜치>
    ```

4. 현재 브랜치가 새로 생성한 브랜치인지 확인합니다.
    ```
    $ git branch -v
    * <내 브랜치> ...
      main ...
    ```

5. 자신의 디렉터리에 파일을 업로드하고 commit & push 합니다.
    ```
    $ git add <업로드할 디렉터리 및 파일>
    $ git commit -m "<작업 내용>"
    $ git push origin <내 브랜치>
    ```


### 코드 내용 업데이트 하기

1. 현재 브랜치가 내 브랜치인지 확인합니다.
    ```
    $ git branch -v
    * <내 브랜치> ...
      main ...
    ```

2. 마지막 커밋 이후 변경 사항을 임시 저장합니다.
    ```
    $ git add .
    $ git stash
    ```

3. `main` 브랜치로부터 코드 변경사항을 가져와 현재 브랜치에 병합합니다.
    ```
    $ git pull origin main
    ```

4. 아까 임시 저장했던 변경 사항을 불러옵니다.
    ```
    $ git stash pop
    ```

