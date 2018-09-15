package crazy.biz;

import java.io.Serializable;
import java.util.Date;

/**
 * moved from view and implements serializable
 * 
 * @author Laurence Cao
 * @date 2018年9月12日
 *
 */
public class HelloWorld implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String name;
	protected String title;
	protected Date created;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
