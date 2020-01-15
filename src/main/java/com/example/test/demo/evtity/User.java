package com.example.test.demo.evtity;

public class User {

    private String code;
    private String message;
    private ResultBean resultBean;

    class ResultBean{
        private String userId;//用户Id;
        private String userName;//用户真实姓名
        private String nickName;//用户昵称
        private String profilePhoto;//头像
        private String registerTime;//注册时间

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getProfilePhoto() {
            return profilePhoto;
        }

        public void setProfilePhoto(String profilePhoto) {
            this.profilePhoto = profilePhoto;
        }

        public String getRegisterTime() {
            return registerTime;
        }

        public void setRegisterTime(String registerTime) {
            this.registerTime = registerTime;
        }

        @Override
        public String toString() {
            return "ResultBean{" +
                    "userId='" + userId + '\'' +
                    ", userName='" + userName + '\'' +
                    ", nickName='" + nickName + '\'' +
                    ", profilePhoto='" + profilePhoto + '\'' +
                    ", registerTime='" + registerTime + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", resultBean=" + resultBean +
                '}';
    }
}
