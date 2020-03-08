package struts2Session.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Namespace(value = "/")
public class TestAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String Welcome1 = "";

	private String Welcome2 = "";

	private String id = "";
	Map<String, Object> application = (Map<String, Object>) ActionContext.getContext().get("application");
	private Map<String, Object> session;

	public TestAction() {

	}

	@Action(value = "/test", results = { @Result(name = "success", location = "/login.jsp"),
			@Result(name = "error", location = "/login.jsp") })
	public String execute() {

		if (!"".equals(id)) {
			application.put("id", id);
		}

		System.out.println(application.get("id"));

		if (getWelcome1().trim().equals("") &&

				getWelcome2().trim().equals("")) {

			addActionError("nothing entered");

			return ERROR;

		}

		if (!getWelcome1().trim().equals("") &&

				!getWelcome2().trim().equals("")) {

			addActionMessage("Both have data!");

			return ERROR;

		}

		if (!getWelcome1().trim().equals("")) {

			getSession().put("ret", "welcome1");

			addActionMessage("Welcome 2 is empty!");

			return ERROR;

		}

		if (!getWelcome2().trim().equals("")) {

			getSession().put("ret", "welcome2");

			addActionMessage("Welcome 1 is empty!");

			return ERROR;

		}
		// getSession().put("ret", "test");

		return SUCCESS;

	}

	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public String getWelcome1() {
		return Welcome1;
	}

	public void setWelcome1(String welcome1) {
		Welcome1 = welcome1;
	}

	public String getWelcome2() {
		return Welcome2;
	}

	public void setWelcome2(String welcome2) {
		Welcome2 = welcome2;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
