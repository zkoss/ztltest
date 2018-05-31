
package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1434.zul")
class B65_ZK_1434Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk xmlns:h="native">
                    <zscript><![CDATA[
	import java.util.*;
	public class Example {
		String a = null;
		String b = null;
		String c = null;
		Example(String a, String b, String c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		public String getA() {return a;}
		public String getB() {return b;}
		public String getC() {return c;}
	}
	List list = new ArrayList();
	for (int i = 0; i < 5; i++)
		list.add(new Example("a" + i, "b" + i, "c" + i));
	]]></zscript>
                    <window id="winExa" border="normal" width="100%" closable="false" left="0px">
                      <label value='If you see "a0 b0 c0" in one cell, it is a bug.'/>
                      <grid id="gridExample" sizedByContent="false" emptyMessage="Nessun elemento trovato" width="99%">
                        <columns>
                          <column label="A"/>
                          <column label="B"/>
                          <column label="C"/>
                        </columns>
                        <rows>
                          <row forEach="${list}" value="${each}">
                            <h:span stubonly="false" class="z-label" title="tooltip">
                              ${ each.a }
                            </h:span>
                            <h:span stubonly="false" class="z-label" title="tooltip">
                              ${ each.b }
                            </h:span>
                            <h:span stubonly="false" class="z-label" title="tooltip">
                              ${ each.c }
                            </h:span>
                          </row>
                        </rows>
                      </grid>
                    </window>
                  </zk>"""

    runZTL(zscript,
      () => {
        verifyTrue("should not see 'a0 b0 c0' in one cell", !jq("td:contains(a0 b0 c0)").exists())
      })

  }
}