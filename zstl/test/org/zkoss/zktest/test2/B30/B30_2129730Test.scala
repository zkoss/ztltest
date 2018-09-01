/* B30_2129730Test.java

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


class B30_2129730Test extends ZTL4ScalaTestCase {
  @Test
  def testztl() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" arg0="./win"?>

<window width="500px" id="win">
<html><![CDATA[
<ol>
<li>If you see "Bill" under First Name.</li>
<li>"Gates" under Last Name.</li>
<li>Nothing under Full Name.</li>
<li>Then it is correct</li>
</ol>
]]></html>
<zscript>
class Person {
    private String _firstName="";
    private String _lastName="";
    
    //getter and setters
    public void setFirstName(String firstName) {
        _firstName = firstName;
    }
    public String getFirstName() {
        return _firstName;
    }
    public void setLastName(String lastName) {
        _lastName = lastName;
    }
    public String getLastName() {
        return _lastName;
    }
    public void setFullName(String f) {
        //do nothing.
    }
    public String getFullName() {
        return _firstName + " " + _lastName;
    }
	}
	
	Person person = new Person();
	person.setFirstName("Bill");
	person.setLastName("Gates");
</zscript>

<listbox sizedByContent="true">
	<listhead>
      <listheader label="First Name" width="100px"/>
      <listheader label="Last Name" width="100px"/>
      <listheader label="Full Name" width="100px"/>
    </listhead>
    <listitem>
      <listcell>
      	<textbox value="@{person.firstName}"/>
      </listcell>
      <listcell>
      	<textbox value="@{person.lastName}"/>
      </listcell>
      <listcell label="@{person.fullName, access='none'}"/>
    </listitem>
  </listbox>
</window>

		"""
    val ztl$engine = engine()
    val win = ztl$engine.$f("win")
    runZTL(zscript, () => {
      sleep(1000);
      //for DataBinding
      var firstName = jq(".z-textbox:eq(0)").`val`()
      verifyEquals("First name: " + firstName, "Bill", firstName)
      var lastName = jq(".z-textbox:eq(1)").`val`()
      verifyEquals("Last Name: " + lastName, "Gates", lastName)
      verifyEquals("Column of Full Name is not empty.", 0,
        jq(jq(".z-listcell:eq(2)").toWidget().$n("cave")).children().length())
    })
  }
}



