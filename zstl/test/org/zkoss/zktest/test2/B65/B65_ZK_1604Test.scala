package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1604.zul")
class B65_ZK_1604Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<label multiline="true">
		1.click "setOld" button, you should not see with any js error. 
	</label>
	<zscript><![CDATA[
	ListModelList model = new ListModelList();
	model.add("A");
	model.add("B");
	model.add("C");
	
	void setModelOld(){
		ListModelList model = lb.getModel();
		lb.setModel(model);
	}
	]]></zscript>
	<button label="setOld" onClick="setModelOld()"/>
	<borderlayout width="300px" height="300px">
		<center flex="true">
			<columnlayout>
				<columnchildren hflex="1">
					<listbox id="lb" model="${model}" hflex="1">
						<template name="model">
							<listitem label="${each}"/>
						</template>
					</listbox>
				</columnchildren>
			</columnlayout>
		</center>
	</borderlayout>
</zk>
    """

    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(setOld)"))
        waitResponse()
        
        verifyFalse("should see no javascript error", jq(".z-error").exists())
      })

  }
}
