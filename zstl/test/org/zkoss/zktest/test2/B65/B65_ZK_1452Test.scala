package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1452.zul")
class B65_ZK_1452Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = <zk xmlns:h="native">
                    <zscript><![CDATA[
	import java.util.*;
	import org.zkoss.zul.*;
	class CustomComparator implements Comparator {
		boolean _ascending;
		CustomComparator(boolean ascending) {
			_ascending = ascending;
		}
		public int compare(Object o1, Object o2) {
			Example e1 = (Example)((Row)o1).getValue();
			Example e2 = (Example)((Row)o2).getValue();
			
			return _ascending ? e1.getA().compareTo(e2.getA()) : e2.getA().compareTo(e1.getA());
		}
	}
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
	CustomComparator asc = new CustomComparator(true);
	CustomComparator desc = new CustomComparator(false);
	]]></zscript>
                    <window id="winExa" border="normal" width="100%" closable="false" left="0px">
                      <label multiline="true">
                        1. Click column A to sort several times.
		2. Should not see js error message.
                      </label>
                      <grid id="gridExample" sizedByContent="false" width="99%">
                        <columns>
                          <column label="A" sortAscending="${desc}" sortDescending="${asc}"/>
                          <column label="B"/>
                          <column label="C"/>
                        </columns>
                        <rows>
                          <row forEach="${list}" value="${each}">
                            <label value="${each.a}" stubonly="true"/>
                            <label value="${each.b}" stubonly="true"/>
                            <label value="${each.c}" stubonly="true"/>
                          </row>
                        </rows>
                      </grid>
                    </window>
                  </zk>

    runZTL(zscript,
      () => {
        1 to 3 foreach { i =>
        	click(jq(".z-column:contains(A)"))
        	waitResponse()
        }
        
        verifyTrue("Should not see js error message", !jq(".z-errbox").exists())
      })

  }
}
