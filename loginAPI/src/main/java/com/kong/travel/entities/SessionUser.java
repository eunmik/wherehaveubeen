package com.kong.travel.entities;

import lombok.Getter;

import java.io.Serializable;

// User클래스를 그대로 사용하면 직렬화를 구현하지 않았기 때문에 에러가 발생한다. 그래서 직렬화된 SessionUser클래스를 만들어준다.
//User클래스를 직렬화 하지 않은 이유는 다른 엔티티와도 연관관계가 생길수 있는 엔티티이기 때문에 성능 이슈, 부수 효과가 발생할 확률이 높기 때문이다.
@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}

