/* B50_ZK_610Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Dec 02 15:27:03 CST 2011 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B50

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.unit.{Element, Widget}
import org.zkoss.ztl._
import org.zkoss.ztl.unit._

/**
  * A test class for bug ZK-610
  *
  * @author benbai
  *
  */
@Tags(tags = "B50-ZK-610.zul,B,E,Grid,Listbox,Tree,sort")
class B50_ZK_610Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<zk>
				<zscript>
					import org.zkoss.zktest.util.Person;
					Person[] ps = new Person[] {
						new Person("A1", "B1"), new Person("A2", "B2"), new Person(null, null)
					};
					ListModelList model = new ListModelList(ps);
					RowRenderer ren = new RowRenderer() {
						public void render(Row row, Object value, int index) {
							String fn = ((Person) value).getFirstName();
							row.appendChild(new Label(fn == null ? "(null)" : fn)); 
						}
					};
				</zscript>
				<div>
					Click on the Column to sort several times. If (null) always stay at the first row, it is a bug.
				</div>
				<grid id="grid" model="${model}" rowRenderer="${ren}">
					<columns id="columns">
						<column sort='auto(firstName)'>Column</column>
					</columns>
				</grid>
			</zk>

    """


    runZTL(zscript, () => {
      var grid: Widget = engine.$f("grid");
      var columns: Widget = engine.$f("columns");

      var cell: Element = jq(grid.$n()).find(".z-row:contains((null))").get(0);

      clickAt(columns, "5,5");
      waitResponse();
      var offset: Integer = jq(cell).positionTop();

      def sortThenVerify = () => {
        clickAt(columns.firstChild(), "5,5");
        waitResponse();

        verifyTrue("the position should changed after sort",
          offset != jq(cell).positionTop());
        offset = jq(cell).positionTop()
      }

      sortThenVerify();
      sortThenVerify();
      sortThenVerify();
      sortThenVerify();
    })
  }

}