package com.github.entity;

public enum Role {

    guest("guest"),
    user("user"),
    admin("admin");

    private String val;

    Role(String val){
        this.val = val;
    }

    public String getVal() {
        return val;
    }

    public static Role getTopic (String str) {
        for(Role each : values()) {
            if(each.getVal().equals(str)) return each;
        }
        throw new IllegalArgumentException("Unhandled role");
    }

}
