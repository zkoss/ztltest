/* B50_ZK_859Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Mar 13 17:55:38 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
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

/**
 * A test class for bug ZK-859
 * @author benbai
 *
 */
@Tags(tags = "B50-ZK-859.zul,B,M,Bandpopup,hflex")
class B50_ZK_859Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = {
			<zk>
				<div>
					Open each of the following Bandbox. The popup position should be correct is each case.
				</div>
				<div>
					<span style="font-style: italic">
						Some Text For Pushing Bandbox to the Right
					</span>
					<bandbox id="bdx">
						<bandpopup hflex="min">
							<listbox hflex="min">
								<listhead>
									<listheader label="Header 0" />
									<listheader label="Header 1" />
								</listhead>
								<listitem>
									<listcell label="Cell 0" />
									<listcell label="Cell 1" />
								</listitem>
							</listbox>
						</bandpopup>
					</bandbox>
					<bandbox id="bdxTwo">
						<bandpopup>
							<listbox width="200px">
								<listhead>
									<listheader label="Header 0" />
									<listheader label="Header 1" />
								</listhead>
								<listitem>
									<listcell label="Cell 0" />
									<listcell label="Cell 1" />
								</listitem>
							</listbox>
						</bandpopup>
					</bandbox>
					<bandbox id="bdxThree">
						<bandpopup hflex="min">
							<vbox hflex="min">
								<hbox hflex="min">
									<label>Search</label>
									<textbox />
								</hbox>
								<listbox hflex="min">
									<listhead>
										<listheader label="Header 0" />
										<listheader label="Header 1" />
									</listhead>
									<listitem>
										<listcell label="Cell 0" />
										<listcell label="Cell 1" />
									</listitem>
								</listbox>
							</vbox>
						</bandpopup>
					</bandbox>
				</div>
			</zk>

    }


   runZTL(zscript, () => {
			var bdx: Widget = engine.$f("bdx");
			var bdxTwo: Widget = engine.$f("bdxTwo");
			var bdxThree: Widget = engine.$f("bdxThree");

			if (ZK.is("ie6_") || ZK.is("ie7_")) {
			  click(bdx.$n("btn"));
			  waitResponse();
			  click(bdxTwo.$n("btn"));
			  waitResponse();
			  click(bdxThree.$n("btn"));
			  waitResponse();
			}
			def check (wgt: Widget) {
			  click(wgt.$n("btn"));
			  waitResponse();
			  verifyTrue("The position of bandpopup should be correct.",
			      jq(wgt.$n()).offsetLeft() == jq(wgt.$n("pp")).offsetLeft());
			}
			check(bdx);
			check(bdxTwo);
			check(bdxThree);
		})
  }
}