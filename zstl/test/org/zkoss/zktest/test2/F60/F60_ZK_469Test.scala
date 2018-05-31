/* F60_ZK_469Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Wed Mar 21 17:34:03 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.F60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.{Tags, Widget}

/**
  * A test class for bug ZK-469
  *
  * @author benbai
  *
  */
@Tags(tags = "F60-ZK-469.zul,F60,A,E,Absolutelayout")
class F60_ZK_469Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
			<?component name="window" extends="window" border="normal" width="300px" height="300px"?>
			<zk>
				<zscript>
				 void changePosition(int x, int y) {
				 	w1.x += x;
				 	w1.y += y;
				 	w1.firstChild.title = "X=" + w1.x + ", Y=" + w1.y;
				 	w2.x += x;
				 	w2.y += y;
				 	w2.firstChild.title = "X=" + w2.x + ", Y=" + w2.y;
				 	w3.x += x;
				 	w3.y += y;
				 	w3.firstChild.title = "X=" + w3.x + ", Y=" + w3.y;
				 }
				</zscript>
				<absolutelayout id="parent">
					<absolutechildren>
					You can test the following button works well as its description.
					<button id="btnOne" label="Add x += 100" onClick="changePosition(100, 0)"/>
					<button id="btnTwo" label="Add x -= 100" onClick="changePosition(-100, 0)"/>
					<button id="btnThree" label="Add y += 100" onClick="changePosition(0, 100)"/>
					<button id="btnFour" label="Add y -= 100" onClick="changePosition(0, -100)"/>
					</absolutechildren>
					<absolutechildren id="w1" x="60" y="100">
						<window title="X=60, Y=100">
						Window 1
						</window>
					</absolutechildren>
					<absolutechildren id="w2" x="160" y="200">
						<window title="X=160, Y=200">
						Window 2
						</window>
					</absolutechildren>
					<absolutechildren id="w3" x="260" y="300">
						<window title="X=260, Y=300">
						Window 3
						</window>
					</absolutechildren>
				</absolutelayout>
			</zk>

    """

    runZTL(zscript,
      () => {
        var parent: Widget = engine.$f("parent");

        var btnOne: Widget = engine.$f("btnOne");
        var btnTwo: Widget = engine.$f("btnTwo");
        var btnThree: Widget = engine.$f("btnThree");
        var btnFour: Widget = engine.$f("btnFour");

        var w1: Widget = engine.$f("w1");
        var w2: Widget = engine.$f("w2");
        var w3: Widget = engine.$f("w3");

        var w1x: Int = 60;
        var w1y: Int = 100;
        var w2x: Int = 160;
        var w2y: Int = 200;
        var w3x: Int = 260;
        var w3y: Int = 300;

        var parentLeft: Int = jq(parent).offsetLeft();
        var parentTop: Int = jq(parent).offsetTop();

        def clickAndVerify(btn: Widget, addX: Int, addY: Int) {
          click(btn);
          waitResponse();
          w1x += addX;
          w1y += addY;
          w2x += addX;
          w2y += addY;
          w3x += addX;
          w3y += addY;

          verifyTrue("The position should be changed correctly",
            math.abs((jq(w1).offsetLeft() - parentLeft - w1x)) < 2 && math.abs(jq(w1).offsetTop() - parentTop - w1y) < 2
              && math.abs((jq(w2).offsetLeft() - parentLeft - w2x)) < 2 && math.abs(jq(w2).offsetTop() - parentTop - w2y) < 2
              && math.abs((jq(w3).offsetLeft() - parentLeft - w3x)) < 2 && math.abs(jq(w3).offsetTop() - parentTop - w3y) < 2);
        }

        clickAndVerify(btnOne, 100, 0);
        clickAndVerify(btnThree, 0, 100);
        clickAndVerify(btnTwo, -100, 0);
        clickAndVerify(btnFour, 0, -100);
      }
    );

  }
}