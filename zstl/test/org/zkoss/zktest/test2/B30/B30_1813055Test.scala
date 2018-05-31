/* B30_1813055Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:00 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

;

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Widget


class B30_1813055Test extends ZTL4ScalaTestCase {
  @Test
  def testDatabinding() = {
    var zscript =
      """
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
<zk	xmlns:h="http://www.w3.org/1999/xhtml" xmlns:zk="http://www.zkoss.org/2005/zk">
<html><![CDATA[
Two listbox share the same selected variable. It used to cause NullPointerException.<br/>
1. You should see 10 same Listitem on two listbox.<br/>
2. Change listbox 1's current selected item, listbox 2 should change its selection to the same item accordingly.<br/>
3. Change listbox 2's current selected item, listbox 1 should change its selection to the same item accordingly.
]]></html>
<zscript><![CDATA[
	public class Person {
		private String _first;
		private String _last;
		
		public Person(String f, String l) {
			setFirstName(f);
			setLastName(l);
		}
		
		public String getFirstName() {
			return _first;
		}
		
		public void setFirstName(String f) {
			_first = f;
		}
		
		public String getLastName() {
			return _last;
		}
		
		public void setLastName(String l) {
			_last = l;
		}
	}

	List persons = new ArrayList(10);
	for(int j=0; j < 10; ++j) {
		persons.add(new Person("First"+j, "Last"+j));
	}
	Person selected = persons.get(0);
]]></zscript>

<groupbox>
	<caption label="listbox1"/>
	<listbox id="lb1" model="@{persons}" selectedItem="@{selected}">
	<listitem each="@{person}">
		<listcell label="@{person.firstName}"/>
		<listcell label="@{person.lastName}"/>
	</listitem>
	</listbox>
</groupbox>

<groupbox>
	<caption label="listbox2"/>
	<listbox id="lb2" model="@{persons}" selectedItem="@{selected}">
	<listitem each="@{person2}">
		<listcell label="@{person2.firstName}"/>
		<listcell label="@{person2.lastName}"/>
	</listitem>
	</listbox>
</groupbox>
</zk>

		"""
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val lb1 = ztl$engine.$f("lb1")
    val lb2 = ztl$engine.$f("lb2")
    runZTL(zscript, () => {
      waitResponse()
      verifyEquals("10", lb1.nChildren())
      verifyEquals("10", lb2.nChildren())
      verifyTrue(jq("@listitem:odd").hasClass("z-listbox-odd"))
      click(lb1.lastChild())
      waitResponse()
      verifyFalse(lb2.firstChild().is("selected"))
      verifyTrue(lb2.lastChild().is("selected"))
      click(lb1.firstChild())
      waitResponse()
      verifyTrue(lb2.firstChild().is("selected"))
      verifyFalse(lb2.lastChild().is("selected"))
      click(lb2.lastChild())
      waitResponse()
      verifyFalse(lb1.firstChild().is("selected"))
      verifyTrue(lb1.lastChild().is("selected"))
      click(lb2.firstChild())
      waitResponse()
      verifyTrue(lb1.firstChild().is("selected"))
      verifyFalse(lb1.lastChild().is("selected"))
    })
  }
}



