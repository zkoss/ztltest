package org.zkoss.zktest.test2.F65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.openqa.selenium.Keys
import org.junit.Test

@Tags(tags = "F65-ZK-1269.zul")
class F65_ZK_1269Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript = """<?page title="new page title" contentType="text/html;charset=UTF-8"?>
<zk>
	<zscript>
	void appendComponent(){
		card.appendChild(new org.zkoss.zul.Label("Component "+card.getChildren().size()));
	}
	
	void addBefore(int index){
		card.insertBefore(
			new org.zkoss.zul.Label("Component " + card.getChildren().size()),
			card.getChildren().get(index)
		);
	}
	
	void remove(int index){
		card.removeChild(card.getChildren().get(index));
	}
	
	void changeOrient(org.zkoss.zkmax.zul.Cardlayout cl){
		cl.setOrient( "horizontal".equals(cl.getOrient()) ? "vertical" : "horizontal");
	}
	</zscript>
	<label multiline="true"><![CDATA[
		* Click "Change Orient", the way of animation will change from "left-right" to "up-down". 
		* Click "next" or "previous" will show next or previous component.
		* Only {component[index] | selectedIndex - 1 <= index <= selectedIndex + 1} will be rendered.
	]]></label>
	<hbox width="800px">
		<label multiline="true" hflex="1"><![CDATA[
	 		Normal and append child test : 
	 		1. Initially, the "Component 9" will be shown. 
	 		2. Click "append component" will add "Component 11" at index 11.
	 		3. Assign selected index "11", will transform "Component 9" to "Component 11"
	 		4. Back to "Component 9"
	 		5. Assign insert before index "9", will add "Component 12" at index 9. 
	 		5.1 Click "show selected index" will alert "10"
	 	]]></label>
		<label multiline="true" hflex="1"><![CDATA[
	 		Remove child test : 
	 		0. Please refresh page first.
	 		1. Assign remove child index "2", will transform "Component 9" to "Component 10"
	 		1.1 Click "show selected index" will show "9".
	 		2. Assign remove child index "9", will transform empty to "Component 9".
	 		2.1 Click "show selected index" will alert "8"
	 		3. Assign selected index "2", will transform "Component 9" to "Component 3"
	 		4. Assign remove child index "7" (no animation will occur)
	 		5. Assign selected index "7", will transform "Component 3" to "Component 9"
	 		6. Assign selected index "0", will transform "Component 9" to "Component 0"
	 		7. Assign remove child index "0", will transform empty to "Component 1".
	 		8. Assign selected index "6", will transform "Component 1" to "Component 9"
	 		9. Assign remove child index "5" (no animation will occur)
	 		9.1 Click "show selected index" will alert "5"
	 	]]></label>
	</hbox>
	<cardlayout id="card" width="300px" height="350px" style="border:1px solid red" selectedIndex="9">
		<window title="Embedded Style" border="normal" width="200px">Component 0</window>
		<borderlayout>
			<west width="20%">
				<label value="west content" />
			</west>
			<center>
				<caption label="center caption" />
				<label value="Component 1" />
			</center>
		</borderlayout>
		<window title="Overlapped Style" zclass="z-window-overlapped" border="normal" width="200px"> Component 2 </window>
		<div vflex="1" hflex="1" style="background-color:yellow;">Component 3 with vflex, hflex</div>
		<div vflex="1" hflex="1" style="background-color:#00FFCC;">Component 4 with vflex, hflex</div>
		<div vflex="1" hflex="1" style="background-color:yellow;">Component 5 with vflex, hflex</div>		
		<div vflex="1" hflex="1" style="background-color:#e4e4e4;">Component 6 with vflex, hflex</div>
		<div vflex="1" hflex="1" style="background-color:yellow;">Component 7 with vflex, hflex</div>
		<div vflex="1" hflex="1" style="background-color:#AAAACC;">Component 8 with vflex, hflex</div>
		<div vflex="1" hflex="1" style="background-color:yellow;">Component 9 with vflex, hflex</div>
		<window title="Popup Style" zclass="z-window-popup" border="normal" width="200px"> Component 10 </window>
	</cardlayout>
	<hlayout>
		<button onClick="card.previous()">previous</button>
		<button onClick="card.next()">next</button>
		<button onClick="changeOrient(card)">change orient</button>
		<button onClick="appendComponent()">append component</button>
	</hlayout>	
	<separator />
	<hlayout>
		selected index : <intbox id="goIndex" />
		<button onClick="card.setSelectedIndex(goIndex.value)">Go</button>
	</hlayout>
	<separator />
	<hlayout>	
		insert before index : <intbox id="insertIndex" />
		<button onClick="addBefore(insertIndex.value)">Add</button>
		<button onClick="alert(card.selectedIndex)">show selected index</button>
	</hlayout>
	<separator />
	<hlayout>	
		remove child index : <intbox id="removeIndex" />
		<button onClick="remove(removeIndex.value)">Remove</button>
	</hlayout>	
	<separator bar="true" />
	
	<label multiline="true">
	<![CDATA[
		vflex="min", hflex="min", selectedIndex="1"
	]]>
	</label>
	<cardlayout id="flexMin" hflex="min" vflex="min" style="border:red 1px solid" selectedIndex="1">
 		<div width="200px" height="250px" style="background-color:red;">
 			index=0, 200 * 250
 		</div> 
 		<div width="250px" height="300px" style="background-color:yellow;">
 			index=1, 250 * 300
 		</div>
	</cardlayout>
	<hlayout>
		<button onClick="flexMin.previous()">previous</button>
		<button onClick="flexMin.next()">next</button>
		<button onClick="changeOrient(flexMin)">change orient</button>
	</hlayout>
	
	<label multiline="true">
	<![CDATA[
		vflex="1" and hflex="1", parent widget is 400 * 300
	]]>
	</label>
	<div width="400px" height="300px">
		<cardlayout id="flex1" hflex="1" vflex="1" style="border:red 1px solid">
	 		<div width="200px" height="350px" style="background-color:yellow;">
	 			index=0, 250 * 350
	 		</div>
	 		<div width="350px" height="200px" style="background-color:red;">
	 			index=1, 200 * 250
	 		</div>
			<div vflex="1" hflex="1" style="background-color:yellow;">
				index=1, vflex=1, hflex=1
			</div>	 		
		</cardlayout>
	</div>
	<hlayout>
		<button onClick="flex1.previous()">previous</button>
		<button onClick="flex1.next()">next</button>
		<button onClick="changeOrient(flex1)">change orient</button>
	</hlayout>
</zk>"""
    runZTL(zscript,
      () => {

        // orient 
        click(jq(".z-button:contains(change orient):eq(0)"))
        waitResponse()
        click(jq(".z-button:contains(next):eq(0)"))
        waitResponse()
        sleep(500)
        verifyTrue("should show component 10.", jq(".z-cardlayout-inner:contains(10)").css("top") == "0px")

        click(jq(".z-button:contains(previous):eq(0)"))
        waitResponse()
        sleep(500)

        // append child
        val selectedInp = jq(".z-hlayout:contains(Go)").find(".z-intbox")
        val insertInp = jq(".z-hlayout:contains(insert)").find(".z-intbox")
        val removeInp = jq(".z-hlayout:contains(Remove)").find(".z-intbox")
        val go = jq(".z-button:contains(Go)")
        val add = jq(".z-button:contains(Add)")
        val remove = jq(".z-button:contains(Remove)")
        val show = jq(".z-button:contains(show selected index)")
        val confirm = jq(".z-messagebox-window .z-button:eq(0)")

        val removeThen = (nth: String, result: String) => {
          sendKeys(removeInp, nth)
          waitResponse(true)
          blur(removeInp)
          waitResponse(true)
          
          click(remove)
          waitResponse(true)
          sleep(1000)
          verifyTrue("should show component " + result + ".", jq(".z-cardlayout-inner:contains(" + result + ")").css("top") == "0px")

          // restore removeInp
          sendKeys(removeInp, Keys.END + ("" + Keys.BACK_SPACE) * removeInp.`val`().length)
          waitResponse(true)
          blur(removeInp)
          waitResponse(true)
        }

        val showThen = (result: String) => {
          click(show)
          waitResponse(true)
          verifyTrue("should show selected index " + result + ".", jq(".z-messagebox-window .z-label").text() == result)

          // confirm
          click(confirm)
          waitResponse(true)
        }

        val selectThen = (nth: String, result: String) => {
          sendKeys(selectedInp, nth)
          waitResponse(true)
          blur(selectedInp)
          waitResponse(true)
          
          click(go)
          waitResponse(true)
          sleep(1000)
          verifyTrue("should show component " + result + ".", jq(".z-cardlayout-inner:contains(" + result + ")").css("top") == "0px")

          // restore selectedInp
          sendKeys(selectedInp, Keys.END + ("" + Keys.BACK_SPACE) * selectedInp.`val`().length)
          waitResponse(true)
          blur(selectedInp)
          waitResponse(true)
        }

        verifyTrue("should show component 9.", jq(".z-cardlayout-inner:contains(9)").css("top") == "0px")
        click(jq(".z-button:contains(append component):eq(0)"))
        waitResponse(true)

        selectThen("11", "11")

        selectThen("9", "9")

        sendKeys(insertInp, "9")
        click(add)
        waitResponse(true)

        showThen("10")

        // restore
        removeThen("12", "9")
        removeThen("9", "10")
        selectThen("9", "9")

        // remove child 
        removeThen("2", "10")

        showThen("9")

        removeThen("9", "9")

        showThen("8")

        selectThen("2", "3")

        removeThen("7", "3")

        selectThen("7", "9")

        selectThen("0", "0")

        removeThen("0", "1")

        selectThen("6", "9")

        removeThen("5", "9")

        showThen("5")

      })

  }
}