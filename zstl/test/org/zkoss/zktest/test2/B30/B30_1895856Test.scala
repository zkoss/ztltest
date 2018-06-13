/* B30_1895856Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1895856Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?> 
<window>
<html><![CDATA[
<p>1. You should see First Name "Hello".<br/>
2. You should see Last Name "ZK".<br/>
3. You should see Full Name "Hello ZK".<br/>
4. Change First Name from "Hello" to "Hi". Full Name is still "Hello ZK".<br/>
5. Now press "Change" button; you should see Full Name changed to "Hi ZK". If you did not see such change, it is a bug.<br/>
</p>  
]]></html>
<zscript>
	public class Person {
		private String _first;
		private String _last;
		
		public Person(String f, String l) {
			setFirstname(f);
			setLastname(l);
		}
		
		public String getFirstname() {
			return _first;
		}
		
		public void setFirstname(String f) {
			_first = f;
		}
		
		public String getLastname() {
			return _last;
		}
		
		public void setLastname(String l) {
			_last = l;
		}
		
		public String getFullname() {
			return _first+" "+_last;
		}
	}
	Person person = new Person("Hello", "ZK");
</zscript>
	<grid><rows>
	<row>First Name<textbox id="fn" value="@{person.firstname,save-when='btn.onClick'}"/></row>
	<row>Last Name<textbox id="ln" value="@{person.lastname,save-when='btn.onClick'}"/></row>
	<row>Full Name<label id="fullname" value="@{person.fullname}"/></row>
	</rows></grid>
	<button id="btn" label="Change" onClick=""/>
</window>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val fn = ztl$engine.$f("fn")
    val ln = ztl$engine.$f("ln")
    val fullname = ztl$engine.$f("fullname")
    val btn = ztl$engine.$f("btn")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      verifyEquals("Hello", jq("$fn").`val`())
      verifyEquals("ZK", jq("$ln").`val`())
      verifyEquals("Hello ZK", jq("$fullname").text())
      typeKeys(jq("$fn"), "hi")
      click(jq("$btn"))
      waitResponse()
      verifyEquals("hi ZK", jq("$fullname").text())
    })
  }
}



