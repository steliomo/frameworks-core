/**
 *
 */
package mz.co.mozview.frameworks.core.webservices.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import mz.co.mozview.frameworks.core.webservices.adapter.MapAdapter;

/**
 * @author Stélio Moiane
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UserContext implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String fullName;

	private String username;

	private String password;

	private String email;

	private String sessionId;

	private boolean accountNonExpired;

	private boolean accountNonLocked;

	private boolean credentialsNonExpired;

	private boolean enabled;

	private UnitWS unit;

	private Role role;

	private String uuid;

	private List<String> transactionCodes;

	private String phoneNumber;

	@XmlJavaTypeAdapter(MapAdapter.class)
	private Map<String, Object> properties;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(final String fullName) {
		this.fullName = fullName;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(final String sessionId) {
		this.sessionId = sessionId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	public void setAccountNonExpired(final boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	public void setAccountNonLocked(final boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	public void setCredentialsNonExpired(final boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(final boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(this.role);
	}

	public void setRole(final Role role) {
		this.role = role;
	}

	public Role getRole() {
		return this.role;
	}

	public void setUnit(final UnitWS unit) {
		this.unit = unit;
	}

	public UnitWS getUnit() {
		return this.unit;
	}

	public List<String> getTransactionCodes() {
		return Collections
		        .unmodifiableList(this.transactionCodes != null ? this.transactionCodes : new ArrayList<String>());
	}

	public void setTransactionCodes(final List<String> transactionCodes) {
		this.transactionCodes = transactionCodes;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setUuid(final String uuid) {
		this.uuid = uuid;
	}

	public String getUuid() {
		return this.uuid;
	}

	@SuppressWarnings("unchecked")
	public <T> T getPropertyValue(final String key) {

		if (this.properties == null) {
			return null;
		}

		return (T) this.properties.get(key);
	}

	public <T> void addProperty(final String key, final T value) {

		if (this.properties == null) {
			this.properties = new HashMap<>();
		}

		this.properties.put(key, value);
	}
}
