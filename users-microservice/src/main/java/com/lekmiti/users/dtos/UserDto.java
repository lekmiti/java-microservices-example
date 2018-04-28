package com.lekmiti.users.dtos;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@ToString
@Accessors
 public class UserDto {
        private String mail;
        private String firstName;
        private String lastName;

        public String getMail() {
                return mail;
        }

        public void setMail(String mail) {
                this.mail = mail;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public UserDto() {
        }

        public UserDto(String userName, String firstName, String lastName) {
                this.mail = userName;
                this.firstName = firstName;
                this.lastName = lastName;
        }
}
