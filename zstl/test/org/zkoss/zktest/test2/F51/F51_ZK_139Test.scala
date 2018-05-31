/* F51_ZK_139Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thu Mar 15 15:08:12 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F51

import java.lang._

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{JQuery, Tags, Widget}

/**
  * A test class for bug ZK-139
  *
  * @author benbai
  *
  */
@Tags(tags = "F51-ZK-139.zul,A,E,template")
class F51_ZK_139Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<vlayout>
				<html><![CDATA[
				<ol>
				<li>Press the "create after..." button and a set of components will be created and appended at the end.</li>
				<li>Press again and a new set will be append.</li>
				<li>Press the "create before..." button and a set of components will be created and inserted before the button.</li>
				<li>Press again and a new set will be inserted.</li>
				</ol>
				]]></html>
			
				<template name="t1">
					${count}: This is date: <datebox/>
					This is native:
						<n:ol xmlns:n="native">
							<n:li>first item</n:li>
							<n:li>second item</n:li>
						</n:ol>
			
					This is listbox
					<zscript>
					ListModel infos = new ListModelArray(
						new String[][] {
							{"Apple", "10kg"},
							{"Orange", "20kg"},
							{"Mango", "12kg"}
						});
					</zscript>
					<listbox model="${infos}">
						<listhead>
							<listheader label="Name"/>
						</listhead>
					</listbox>
				</template>
				<zscript>
				public class VResolver implements org.zkoss.xel.VariableResolver {
					int count = 0;
					public Object resolveVariable(String name) {
						if ("count".equals(name))
							return ++count;
						return null;
					}
				}
				VResolver resolver = new VResolver();
				</zscript>		
			
				<button id="btnOne" label="create after from template"
					onClick='self.parent.getTemplate("t1").create(self.parent, null, resolver, null)'/>
				<button id="btnTwo" label="create before from template"
					onClick='self.parent.getTemplate("t1").create(self.parent, self, resolver, null)'/>
			</vlayout>

    """

    runZTL(zscript,
      () => {
        var btnOne: Widget = engine.$f("btnOne");
        var btnTwo: Widget = engine.$f("btnTwo");

        def verifyInsert(msg: String, wgt: Widget, before: Boolean, target: Widget) {
          click(wgt);
          waitResponse();
          var inserted: JQuery = jq(".z-label:contains(" + msg + ")");
          if (before) {
            verifyTrue("Template should inserted before",
              inserted.offsetTop() < jq(target).offsetTop());
          } else {
            verifyTrue("Template should inserted after",
              inserted.offsetTop() > jq(target).offsetTop());
          }
        }

        verifyInsert("1: This is date:", btnOne, false, btnTwo);
        verifyInsert("2: This is date:", btnOne, false, btnTwo);
        verifyInsert("3: This is date:", btnTwo, true, btnTwo);
        verifyInsert("4: This is date:", btnTwo, true, btnTwo);
      }
    );
  }
}