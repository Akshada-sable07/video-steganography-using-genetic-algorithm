/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package video_steganography;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author welcome
 */
public class EmailIdFetcher
{
    public String getEmailID(Statement st, String username)
    {
        String email="";
        try
        {
//              Class.forName("com.mysql.jdbc.Driver").newInstance();
//            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/datasteganography","root","root");
//            Statement st=conn.createStatement();
            
            String query="select * from registration_info where user_name='"+username+"'";
            ResultSet rs=st.executeQuery(query);
            
            if(rs.next())
            {
                email=rs.getString(2);
            }
        }
        catch(Exception ex)
        {
            System.out.println("Exception is:"+ex);
        }
        
        return email;
    }
}
