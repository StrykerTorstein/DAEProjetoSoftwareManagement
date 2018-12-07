package ejbs;

import enums.ConfigurationState;
import org.json.simple.JSONObject;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;


@Singleton
@Startup
public class ConfigBean {

    @EJB
    private CourseBean courseBean;
    
    @EJB
    private StudentBean studentBean;

    @EJB
    private TeacherBean teacherBean;
    
    @EJB
    private SubjectBean subjectBean;

    @EJB
    private CharacteristicBean characteristicBean;

    @EJB
    private ConfigurationBean configurationBean;
    
    @PostConstruct
    public void populateBD() {

        try {
            JSONObject obj = new JSONObject();
            obj.put("someKey","someValue");
            String jsonString = obj.toJSONString();
            characteristicBean.create("characteristict1",jsonString);
            configurationBean.create("config1","conf1 description", ConfigurationState.ACTIVE,"Java EE Developer");
            configurationBean.addCharacteristicToConfiguration("config1","characteristict1");
/*
            courseBean.create(1, "EI");            
            courseBean.create(2, "IS");
            courseBean.create(3, "JDM");
            courseBean.create(4, "SIS");
            courseBean.create(5, "MEI-CM");
            courseBean.create(6, "MGSIM");
            
            subjectBean.create(1, "DAE", 1, "2018/19", "2018/19");

            studentBean.create("foo", "foo", "Foo", "foo@ipleiria.pt", 1);
            studentBean.create("bar", "bar", "Bar", "bar@ipleiria.pt", 1);
            
            studentBean.enrollStudentInSubject("foo", 1);
            */

        } catch (Exception e) {
            System.err.println("[ERROR] @ Application bootstrap | Cause: " + e.getMessage());
        }
    }
}
