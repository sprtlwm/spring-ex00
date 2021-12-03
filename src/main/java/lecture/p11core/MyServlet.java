package lecture.p11core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter(onMethod_=@Autowired)
public class MyServlet {

	private MyDao myDao;

//	@Autowired
//	public MyServlet(MyDao myDao) {
//		this.myDao = myDao;
//	}
}
