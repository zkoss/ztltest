/* B30_1888911Test.java

	Purpose:
		
	Description:
		
	History:
		May, 30, 2018 18:42:01 PM

Copyright (C) 2018 Potix Corporation. All Rights Reserved.
*/
package org.zkoss.zktest.test2.B30

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.Widget


class B30_1888911Test extends ZTL4ScalaTestCase {
  @Test
  def testBind() = {
    var zscript =
      """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?> 
			<window id="mainwin">
			<html><![CDATA[
			<p>You should see three rows with top auxheader "person1", "person2", and "person3". 
			And then the column headers of "BBB" and contents "test". If you did not
			see them, it is a bug!</p>
			]]></html>
					<zscript><![CDATA[
						import java.util.*;
						
						public class Person {
							private String _name;
							
							public Person(String name) {
								super();
								_name = name;
							}
						
							public String getName() {
								return _name;
							}
						
							public void setName(String name) {
								_name = name;
							}
						}
						
						List persons = new ArrayList();
						persons.add(new Person("person 1"));
						persons.add(new Person("person 2"));
						persons.add(new Person("person 3"));
					]]></zscript>
			<grid model="@{persons}">
				<columns>
					<column label="Name"/>
				</columns>
				<rows>
					<row self="@{each=q}">
						<groupbox>
							<grid>
								<auxhead>
									<auxheader label="@{q.name}"/>
								</auxhead>
								<columns>
									<column label="BBB"/>
								</columns>
								<rows>
									<row><label value="test"/></row>
								</rows>
							</grid>
						</groupbox>
					</row>
				</rows>
			</grid>
			</window>
		"""
    val ztl$engine = engine()
    val mainwin = ztl$engine.$f("mainwin")
    runZTL(zscript, () => {
      sleep(1000); //for DataBinding
      for (i <- 1 until 4) {
        verifyEquals("BBB", jq(".z-column:eq(" + i + ")").text())
      }
    })
  }
}



