/* B60_ZK_1338Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Thur. September 6 17:22:35 CST 2012 , Created by jumperchen
}}IS_NOTE

Copyright (C) 2012 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

/**
  * A test class for bug ZK-1338
  *
  * @author jumperchen
  *
  */
@Tags(tags = "B60-ZK-1338.zul,A,E,ClientEngine,Javascript")
class B60_ZK_1338Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """	<?page title="If nothing in the page, that is a bug"?>
<?script content="zk.log('if nothing in the page, that is a bug')"?>
<zk xmlns:w="http://www.zkoss.org/2005/zk/client">
<zscript><![CDATA[
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zkoss.lang.Threads;
import org.zkoss.web.util.resource.ClassWebResource;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.http.WebManager;
import org.zkoss.zk.ui.http.WpdExtendlet;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.io.IOException;

public class MyComposer extends GenericForwardComposer {
	ClassWebResource cwr;
	public void doAfterCompose(Component comp) throws Exception {
		super.doAfterCompose(comp);
		cwr = WebManager.getWebManagerIfAny(comp.getDesktop().getWebApp()).getClassWebResource();
		cwr.addExtendlet("wpd", new MyWpdExtendlet());
	}
	class MyWpdExtendlet extends WpdExtendlet {
		public void service(HttpServletRequest request,
		HttpServletResponse response, String path) throws ServletException, IOException  {
			if (path.indexOf("mesh.wpd") >= 0) {
				if (cwr != null)
					cwr.addExtendlet("wpd", new WpdExtendlet());
				Threads.sleep(3000);
			}
			super.service(request, response, path);
		}
	}
}
]]></zscript>
	<window id="mainWin" border="normal" width="800px" vflex="1"
		apply="MyComposer">
		<custom-attributes org.zkoss.zul.image.preload="true"/>
		<zscript><![CDATA[
			ListModel model = new org.zkoss.zktest.test2.grid.FakeListModel(40);
		]]></zscript>
		<caption label="Join ZK">
			<hlayout>
				<label id="curr_step" value="0" />
				%
				<progressmeter id="curr_met" value="0" width="300px" />
			</hlayout>
		</caption>
		<listbox model="${model}" vflex="1">
			<template name="model">
				<listitem>
					<listcell label="${each}"/>
				</listitem>
			</template>
		</listbox>
	</window>
</zk>
    	
"""
    runZTL(zscript,
      () => {
        try {
          sleep(5000);
          waitResponse();

          verifyTrue("Window should be there!",
            engine.$f("mainWin").exists());
        } finally {
          var resetScript =
            """
        			<zscript><![CDATA[
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.zkoss.lang.Threads;
import org.zkoss.web.util.resource.ClassWebResource;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.http.WebManager;
import org.zkoss.zk.ui.http.WpdExtendlet;
import org.zkoss.zk.ui.util.GenericForwardComposer;
import java.io.IOException;
        ClassWebResource cwr = WebManager.getWebManagerIfAny(self.getDesktop().getWebApp()).getClassWebResource();
		cwr.addExtendlet("wpd", new org.zkoss.zk.ui.http.WpdExtendlet());
        			]]></zscript>
        			""";
          runRawZscript(resetScript);
          waitResponse();
        }
      }
    );
  }
}