package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import scala.collection.JavaConversions._
import org.junit.Test;
import org.zkoss.ztl.Element;
import org.zkoss.ztl.JQuery;
import org.zkoss.ztl.Tags;
import org.zkoss.ztl.util.Scripts;
import org.zkoss.ztl.Widget;
import org.zkoss.ztl.ZK;
import org.zkoss.ztl.ZKClientTestCase;
import java.lang._

@Tags(tags = "B50-2998196.zul,A,E,Frozen,Grid")
class B50_2998196Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?xml version="1.0" encoding="UTF-8"?>
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" root="./window"?>
<zk>
<html>
<![CDATA[
<ol>
<li>Press the "Test Dynamic Decimal Format Pattern" button and you shall see "154.23" show on the decimalbox.</li>
<li>If not, it is a bug.</li>
<li>Done</li>
</ol>
]]>
</html>
<window id="window">
	<zscript><![CDATA[
		//prepare the example person object
		java.math.BigDecimal numberValue = new java.math.BigDecimal(128990.21);
		class Test{
			String pattern;
			java.math.BigDecimal value;
			public Test(java.math.BigDecimal value,String pattern){
				this.value = value;
				this.pattern = pattern;
			}
			
			public String getPattern(){return pattern;}
			public java.math.BigDecimal getValue(){return value;}
			public void setPattern(String pattern){this.pattern = pattern;}
			public void setValue(java.math.BigDecimal value){this.value=value;}
		}
	]]>
	</zscript>
	<button label="Test Dynamic Decimal Format Pattern">
		<attribute name="onClick">
			<![CDATA[
				window.getAttribute("binder").bindBean("test",new Test(new java.math.BigDecimal(154.233),"#,###.00"));
				window.getAttribute("binder").loadComponent(box);
			]]>
		</attribute>
	</button>
	<decimalbox id="box" format="@{test.pattern}" value="@{test.value}" width="300px"/>
</window>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq("@button"));
        waitResponse();
        verifyEquals("154.23", jq(".z-decimalbox").`val`());
      });
  }

}