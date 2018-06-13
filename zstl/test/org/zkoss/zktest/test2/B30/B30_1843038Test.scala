/* B30_1843038Test.java

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


class B30_1843038Test extends ZTL4ScalaTestCase {
  @Test
  def testDatabinding() = {
    var zscript =
      """
				<zk>
					<window width="500px">
					<zscript><![CDATA[
					
					List strings = new ArrayList();
					for(int j= 0; j < 20; ++j)
					{
					strings.add("test"+j);
					}
					String testStr = "Ths is a test!!!";
					import org.zkoss.zk.ui.util.Composer;
					public class AnnotatedDatabinderComposer implements Composer
					{
						public void doAfterCompose(Component comp) throws Exception
						{
							AnnotateDataBinder binder = new AnnotateDataBinder(comp, true);
							comp.setAttribute("binder", binder, true);
							binder.loadAll();
						}
					
					}
					
					AnnotatedDatabinderComposer composer = new AnnotatedDatabinderComposer();
					]]></zscript>
					<label value="[ 1843038 ] Fulfill doesn't support EL in apply property"/>
					<label value="While clicking this button, there must be a grid with data of String list."/>
					<button id="bt1" label="show" onClick='alert(grid.getModel()+"")'/>
					<div fulfill="bt1.onClick">
					<label value="${testStr}"/>
					<grid id="grid" height="500px" model="@{strings}"
					apply="${composer}">
					
					<columns>
					<column label="First Name"/>
					<column label="desc"/>
					</columns>
					<rows>
					<row self="@{each=str}">
					<label value="@{str}"/>
					<label value="${testStr}"/>
					</row>
					</rows>
					</grid>
					</div>
					
					</window>
				</zk>
			 """
    val ztl$engine = new Widget(new StringBuffer("zk.Desktop._dt"))
    val bt1 = ztl$engine.$f("bt1")
    val grid = ztl$engine.$f("grid")
    runZTL(zscript, () => {
      click(jq(bt1))
      waitResponse()
      if (jq(grid).exists()) {
        verifyTrue(jq(".z-row").length() == 20)
      } else {
        verifyTrue(false)
      }
    })
  }
}



