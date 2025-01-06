package com.xworkz.xworkzCommonModuleGunashreeB.repository;


import com.xworkz.xworkzCommonModuleGunashreeB.dto.UserDTO;
import com.xworkz.xworkzCommonModuleGunashreeB.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;


@Repository
public class UserRepositoryImpl implements  UserRepository{


    @Autowired
    EntityManagerFactory emf;
    @Override
    public boolean save(UserEntity userEntity) {

        System.out.println("data in repoImpl:"+userEntity.toString());
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        try{
            et.begin();
            em.persist(userEntity);
            et.commit();
        }
        catch(Exception e)
        {
            if(et.isActive())
            {
                et.rollback();
            }

        }
        finally {
            em.close();
            //` emf.close();
        }

        return true;
    }

    @Override
    public UserEntity getAll(String email) {

        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        UserEntity entity=null;
        try{
            et.begin();

            entity=(UserEntity) em.createNamedQuery("getAllByEmail").setParameter("ByEmail",email).getSingleResult();

            et.commit();
        }
        catch(Exception e)
        {
            if(et.isActive())
            {
                et.rollback();
            }

        }
        finally {
            em.close();
            //` emf.close();
        }

       if(entity!=null)
        {

            return entity;
        }

        return null;
    }

    @Override
    public Long getNameCount(String name) {

        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        Long count= (Long)em.createNamedQuery("countName").setParameter("ByName",name).getSingleResult();
        try{
            et.begin();

            et.commit();
        }
        catch(Exception e)
        {
            if(et.isActive())
            {
                et.rollback();
            }

        }
        finally {
            em.close();
            //` emf.close();
        }


        return count;
    }



    @Override
    public Long countField(String queryName, String paramName, Object value) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Long count = 0L;

        try {
            et.begin();
            count = (Long) em.createNamedQuery(queryName)
                    .setParameter(paramName, value)
                    .getSingleResult();
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }

        return count;
    }

    @Override
    public Long getPhoneCount(Long phone) {
        return countField("countPhone", "ByPhone", phone);
    }

    @Override
    public Long getAltEmailCount(String email) {
        return countField("countAltEmail", "ByAltEmail", email);
    }

    @Override
    public Long getEmailCount(String email) {
        return countField("countEmail", "ByEmail", email);
    }

    @Override
    public Long getAltPhoneCount(Long altPhoneNumber) {
        return countField("countAltPhone", "ByAltPhone", altPhoneNumber);
    }

    @Override
    public boolean updateDetails(String name,UserDTO dto,String filePath) {


        System.out.println(dto.toString());
        System.out.println(name);
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        boolean isUpdated=false;
        try{
            et.begin();
            int value= em.createNamedQuery("updateDetails").setParameter("setEmail",dto.getEmail()).setParameter("setPhone",dto.getPhone()).setParameter("setAltEmail",dto.getAlternateEmail()).setParameter("setAltPhone",dto.getAlternatePhone()).setParameter("setLocation",dto.getLocation()).setParameter("setUpdatedName",dto.getName()).setParameter("setUpdatedDate", LocalDateTime.now()).setParameter("setFilePath",filePath).setParameter("byName",name).executeUpdate();
            if(value>0)
            {
                isUpdated=true;

                System.out.println("updated");
            }
            else
            {
                isUpdated=false;
                System.out.println("not Updated");
            }
            et.commit();
        }
        catch(Exception e)
        {
            if(et.isActive())
            {
                et.rollback();
            }

        }
        finally {
            em.close();
            //` emf.close();
        }
        if(isUpdated)
        {
            System.out.println("updated");
            return true;
        }
        else
        {
            System.out.println("not Updated");
            return  false;
        }



    }


    @Override
    public UserEntity getAllByName(String name) {
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        UserEntity entity=null;
        try{
            et.begin();
            entity= (UserEntity) em.createNamedQuery("getAllByName").setParameter("ByName",name).getSingleResult();
            et.commit();
        }
        catch(Exception e)
        {
            if(et.isActive())
            {
                et.rollback();
            }

        }
        finally {
            em.close();
            //` emf.close();
        }

        if(entity!=null)
        {
            return entity;
        }
        return null;
    }

    @Override
    public boolean updatePasswordAndLoginCount(String name,String confirmPassword,int loginCount) {
        int loginValue=loginCount+1;
        System.out.println(confirmPassword);
        System.out.println(loginValue);
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();

        boolean isUpdated=false;
        try{
            et.begin();
            int value= em.createNamedQuery("updatePassword").setParameter("SetPassword",confirmPassword).setParameter("SetLoginCount",loginValue).setParameter("ByName",name).executeUpdate();
            if(value>0)
            {
                isUpdated=true;

                System.out.println("updated");
            }
            else
            {
                isUpdated=false;
                System.out.println("not Updated");
            }
            et.commit();
        }
        catch(Exception e)
        {
            if(et.isActive())
            {
                et.rollback();
            }

        }
        finally {
            em.close();
            //` emf.close();
        }
        if(isUpdated)
        {
            System.out.println("updated");
            return true;
        }
        else
        {
            System.out.println("not Updated");
            return  false;
        }


        // return false;
    }

    @Override
    public void updateLoginCount(String email,int loginCount) {
        int count=loginCount+1;
        EntityManager em=emf.createEntityManager();

        EntityTransaction et=em.getTransaction();
        int value;
        try{
            et.begin();

            value= em.createNamedQuery("updateLoginCount").setParameter("SetLoginCount",count).setParameter("byEmail",email).executeUpdate();
            et.commit();
        }
        catch(Exception e)
        {
            if(et.isActive())
            {
                et.rollback();
            }

        }
        finally {
            em.close();
            //` emf.close();
        }




    }

    @Override
    public boolean resetLoginCount(String email, int loginCount) {
       int count=0;
        EntityManager em=emf.createEntityManager();
        EntityTransaction et=em.getTransaction();
        int value=0;
        try{
            et.begin();
            value= em.createNamedQuery("resetLoginCount").setParameter("SetLoginCount",count).setParameter("byEmail",email).executeUpdate();
            et.commit();
        }
        catch(Exception e)
        {
            if(et.isActive())
            {
                et.rollback();
            }

        }
        finally {
            em.close();
            //` emf.close();
        }
        if(value>0)
        {
            return true;
        }
        else
            return false;




    }

    @Override

        public boolean saveEmail(String email, String password) {

        System.out.println(email + password);
        final String username ="gunashreebayanna@gmail.com";
        final String userPassword = "txbg hrvx fycb jhre";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        System.out.println("=================================================");
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, userPassword);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Your password");
            message.setText("your password : "+password);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }



        return true;
   }
    }

