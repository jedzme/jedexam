package com.highrise.exam.web.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(strict = false)
public class ContactData implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3948428575653251756L;
	
	@ElementList(name="instant-messengers", required=false)
	List<InstantMessenger> instantMessengers;
	
	@ElementList(name="twitter-accounts", required=false)
	List<TwitterAccount> twitterAccounts;
	
    @ElementList(name="phone-numbers", required=false)
    List<PhoneNumber> phoneNumbers;
    
    @ElementList(name="web-addresses", required=false)
    List<WebAddress> webAddresses;

    @ElementList(name="email-addresses", required=false)
    List<EmailAddress> eMailAddresses;
    
    @ElementList(name="addresses", required=false)
    List<Address> addresses;

	public List<InstantMessenger> getInstantMessengers() {
		return instantMessengers;
	}

	public void setInstantMessengers(List<InstantMessenger> instantMessengers) {
		this.instantMessengers = instantMessengers;
	}

	public List<TwitterAccount> getTwitterAccounts() {
		return twitterAccounts;
	}

	public void setTwitterAccounts(List<TwitterAccount> twitterAccounts) {
		this.twitterAccounts = twitterAccounts;
	}

	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

	public List<WebAddress> getWebAddresses() {
		return webAddresses;
	}

	public void setWebAddresses(List<WebAddress> webAddresses) {
		this.webAddresses = webAddresses;
	}

	public List<EmailAddress> geteMailAddresses() {
		return eMailAddresses;
	}

	public void seteMailAddresses(List<EmailAddress> eMailAddresses) {
		this.eMailAddresses = eMailAddresses;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
    

}
