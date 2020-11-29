package org.apache.commons.mail;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;
import junit.framework.TestCase;

public class EmailAddHeaderTest extends TestCase {
	Email testEmail;
	
	public void setUp() throws EmailException {
		testEmail = new SimpleEmail();
	}

	/* addHeader() Testing Suite
	 * Three testing cases
	 * Reused from project 1
	 */
    	@Test
    	public void testAddHeaderNormal() {
		System.out.println("This is Add Header Normal Test by Bruce Tian - fcy416 \n Goal is true.");
    		testEmail.addHeader("Test", "Test Content");
        	assertEquals("Test=Test Content", testEmail.headers.toString().replaceAll("\\{", "").replaceAll("\\}",""));
    	}
    
	@Test
    	public void testAddHeaderException1() {
		System.out.println("This is Add Header with first case of exception Test by Bruce Tian - fcy416 \n Goal is handle exception.");
    		try {
    			testEmail.addHeader("", "Fail without id");
    			fail("Waiting for IllegalArgumentException(\"name can not be null or empty\")");
    		} catch (IllegalArgumentException e) {
    			return;
    		}
    		assertEquals("", testEmail.headers.toString().replaceAll("\\{", "").replaceAll("\\}",""));
    	}
    
	@Test
	public void testAddHeaderException2() {
		System.out.println("This is Add Header with second case of exception Test by Bruce Tian - fcy416 \n Goal is handle exception.");
    		try {
    			testEmail.addHeader("Fail without Value", "");
    			fail("Waiting for IllegalArgumentException(\"value can not be null or empty\")");
    		} catch (IllegalArgumentException e) {
    			return;
    		}
    		assertEquals("", testEmail.headers.toString().replaceAll("\\{", "").replaceAll("\\}",""));
    	}

	public void tearDown() {
   	}
}
