package factory;

import entities.Member;

public class MemberFactory {

    public static Member createMember(int id, String name) {
        return new Member(id, name);
    }
}
