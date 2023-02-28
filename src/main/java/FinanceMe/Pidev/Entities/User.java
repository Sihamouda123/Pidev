package FinanceMe.Pidev.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


    @Getter
    @Setter
    @NoArgsConstructor
    @Entity
    @Table(name = "User")

    public class User implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="idUser")
        private Integer idUser;
        private String FirstName;
        private String LastName;
        private Date BirthDate;
        private String PlaceBirth;
        private String fnc;
        private String Gender;
        private String Adress;
        private Integer PostalCode;
        private String Email;

        public void setEmail(String email) {
            Email = email;
        }

        private String PhoneNumber;
        private String password;

        private String username;

        public User(String username, String email, String encode) {
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        @Override
        public String toString() {
            return "User{" +
                    "idUser=" + idUser +
                    ", FirstName='" + FirstName + '\'' +
                    ", LastName='" + LastName + '\'' +
                    ", BirthDate=" + BirthDate +
                    ", PlaceBirth='" + PlaceBirth + '\'' +
                    ", fnc='" + fnc + '\'' +
                    ", Gender='" + Gender + '\'' +
                    ", Adress='" + Adress + '\'' +
                    ", PostalCode=" + PostalCode +
                    ", Email='" + Email + '\'' +
                    ", PhoneNumber='" + PhoneNumber + '\'' +
                    ", password='" + password + '\'' +
                    ", username='" + username + '\'' +
                    ", Account=" + Account +
                    ", roles=" + roles +
                    '}';
        }

        @OneToMany(cascade = CascadeType.ALL)
        private Set<Account> Account;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(  name = "user_roles",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id"))
        private Set<Role> roles = new HashSet<>();

        public Integer getIdUser() {
            return idUser;
        }

        public String getFirstName() {
            return FirstName;
        }

        public String getLastName() {
            return LastName;
        }

        public Date getBirthDate() {
            return BirthDate;
        }

        public String getPlaceBirth() {
            return PlaceBirth;
        }

        public String getFnc() {
            return fnc;
        }

        public String getGender() {
            return Gender;
        }

        public String getAdress() {
            return Adress;
        }

        public Integer getPostalCode() {
            return PostalCode;
        }

        public String getEmail() {
            return Email;
        }

        public String getPhoneNumber() {
            return PhoneNumber;
        }

        public String getPassword() {
            return password;
        }


        public Set<Account> getAccount() {
            return Account;
        }

    }
