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

public class EmailAddCCTest extends TestCase {
	Email testEmail;
	
	public void setUp() throws EmailException {
		testEmail = new SimpleEmail();
	}

	/* AddCc() Testing Suite
	 * Three testing cases
	 * Reused from project 1
	 */
	@Test
	public void testAddCcNormal() throws EmailException, AddressException {
		System.out.println("This is Add CC Normal Test by Bruce Tian - fcy416 \n Goal is true.");
		testEmail.addCc("testa@test.com");
		assertEquals("testa@test.com", testEmail.getCcAddresses().toString().replaceAll("\\[", "").replaceAll("\\]",""));
	}

	@Test
	public void testAddCcArrays() throws EmailException, AddressException {
		System.out.println("This is Add CC Pass an Array Test by Bruce Tian - fcy416 \n Goal is true.");
		String[] emailArray = {"testa@test.com", "test.a@test.net"};
	        testEmail.addCc(emailArray);
		ArrayList<InternetAddress> emailListEx = new ArrayList<InternetAddress>();
		emailListEx.add(new InternetAddress("testa@test.com"));
		emailListEx.add(new InternetAddress("test.a@test.net"));
	        assertEquals(emailListEx.toString(), this.testEmail.getCcAddresses().toString());
	}

	@Test
	public void testAddCcWithEncoding() throws EmailException, UnsupportedEncodingException {
		System.out.println("This is Add CC with Specific Encoding Test by Bruce Tian - fcy416 \n Goal is true.");
		testEmail.addCc("testa@test.com", "test", EmailConstants.UTF_8);
		assertEquals(new InternetAddress("testa@test.com", "test", EmailConstants.UTF_8).toString(), testEmail.getCcAddresses().toString().replaceAll("\\[", "").replaceAll("\\]",""));
	}

	public void tearDown() {
   	}
}
