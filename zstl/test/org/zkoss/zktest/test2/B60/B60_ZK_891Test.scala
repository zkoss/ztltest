/* B60_ZK_891Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Mar 30 15:34:34 CST 2012 , Created by benbai
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

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
 * A test class for bug ZK-891
 * @author benbai
 *
 */
@Tags(tags = "B60-ZK-891.zul,A,E,BindingListModelList,Databinding")
class B60_ZK_891Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
			<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit" ?>
			<zk>
				<window >
				
				<zscript><![CDATA[
					List list = new ArrayList();
					
					for (int i = 0; i < 10; i++) {
						list.add("item " + i);
					}
					
					ListModelList model = new ListModelList(list);
					model.setMultiple(true);
					model.addSelection(model.getElementAt(2));
					
					
					
					Set set = new HashSet();
					
					for (int i = 0; i < 10; i++) {
						set.add("item " + i);
					}
					
					ListModelSet model2 = new ListModelSet(set);
					model2.setMultiple(true);
					model2.addSelection(model2.getElementAt(2));
				]]></zscript>
				<listbox width="150px"  model="@{model}" checkmark="true">
					<listhead>
						<listheader label="col"/>
					</listhead>
					<listitem self="@{each=item}" label="@{item}"/>
				</listbox>
			
				<listbox width="150px"  model="@{model2}" checkmark="true">
					<listhead>
						<listheader label="col"/>
					</listhead>
					<listitem self="@{each=item}" label="@{item}"/>
				</listbox>
				</window>
			</zk>

    """

    runZTL(zscript,
        () => {
        verifyTrue("Should be multiple select",
            jq(".z-listitem-checkbox").length() == 20);
    }
   );
  }
}