package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1693.zul")
class B65_ZK_1693Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<label multiline="true">
	1. Try change the color by the four colorboxs.
	2. If the background color/foreground color of the chart didn't change, it is a bug. 
	</label>
	<window onOK="doOK()" width="350px">
		<chart id="dial" title="Dial Plot" width="300" height="300" type="dial" threeD="false" fgAlpha="128">
			<zscript><![CDATA[
			import java.util.ArrayList;
			import org.zkoss.zul.ListModelList;
			import org.zkoss.zul.DialModel;
			import org.zkoss.zul.DialModelScale;
			int val= 40;
			
			DialModel dialmodel = new DialModel();
			dialmodel.setFrameBgColor("#FF0000");
			dialmodel.setFrameBgColor1("#83C783");
			dialmodel.setFrameBgColor2("#008A00");
			dialmodel.setFrameFgColor("#0000FF");
			
			DialModelScale scale = dialmodel.newScale(0.0, 100.0, -120.0, -300.0, 10.0, 4);//scale's configuration data
			scale.setText("Temperature");
			scale.newRange(80, 100, "#FF0000", 0.83, 0.89);
			scale.newRange(60, 80, "#FFC426", 0.83, 0.89);
			scale.setValue(val);
			
			dial.setModel(dialmodel);
			
			ArrayList list = new ArrayList();
			list.add("vertical");
			list.add("horizontal");
			list.add("center_horizontal");
			list.add("center_vertical");
			ListModelList selModel = new ListModelList(list);
			
			void doOK() {
				val = dbx.getValue();
				if (val > 100)
					val = 100;
				else if (val < 0)
					val = 0;
				
				dbx.value = val;
				slx.curpos = val;
				scale.setValue(val);
				if (val > 80) 
					scale.setNeedleColor(scale.getRange(0).getRangeColor());
				else if (val > 60)
					scale.setNeedleColor(scale.getRange(1).getRangeColor());
				else
					scale.setNeedleColor(dialmodel.getFrameFgColor());
				
				dialmodel.setFrameBgColor(bgColor.getColor());
				dialmodel.setFrameBgColor1(bgColor1.getColor());
				dialmodel.setFrameBgColor2(bgColor2.getColor());
				dialmodel.setFrameFgColor(fgColor.getColor());
				int index = sbx.getSelectedIndex();
				dialmodel.setGradientDirection((String)selModel.get(index < 0 ? 0 : index));
			}
			]]></zscript>
		</chart>
		<vlayout>
			Scale
			<slider id="slx" curpos="${val}" onScroll="dbx.value=self.curpos; doOK()" />
			<intbox id="dbx" value="${val}" onChange="doOK()" />
			Background color
			<colorbox id="bgColor" value="#FF0000" onChange="doOK()" />
			Gradient background color 1
			<colorbox id="bgColor1" value="#83C783" onChange="doOK()" />
			Gradient background color 2
			<colorbox id="bgColor2" value="#008A00" onChange="doOK()" />
			Gradient Direction
			<selectbox id="sbx" model="${selModel}" onSelect="doOK()" />
			Foreground color
			<colorbox id="fgColor" value="#0000FF" onChange="doOK()" />
		</vlayout>
	</window>
</zk>"""
    runZTL(zscript,
      () => {
        verifyImage()
        List("ff0000", "009900", "0000ff", "ffff00").zipWithIndex foreach {
          case (color, index) =>
            val cb = jq(".z-colorbox:eq(" + index + ")")
            click(cb)
            waitResponse()
            sleep(500)
            val pp = jq("#" + cb.attr("id") + "-pp")
            click(pp.find(".z-colorpalette-colorbox:contains(" + color + ")"))
            waitResponse()
            verifyImage()
        }
      })

  }
}