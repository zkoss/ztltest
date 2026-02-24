import { ClientFunction, Selector } from "testcafe";
import * as ztl from "./module/ztl.js";
fixture`ZTL TEST - B80-ZK-2716TestCafe`
	.page`http://localhost:8080/zktest/ztl.zul`.beforeEach(async () => {
	await ClientFunction(() => {
		window["%hammerhead%"].processors.DomProcessor.processJsAttrValue =
			function (value, options) {
				return value;
			};
	})();
});
test("B80-ZK-2716TestCafe", async (t) => {
	await ztl.initTest(t);
	await ztl.runZscript(
		t,
		`<?xml version="1.0" encoding="UTF-8"?>

<!--
B80-ZK-2716.zul

  Purpose:
    
  Description:
    
  History:
    Tue, Apr 21, 2015  5:13:18 PM, Created by Chunfu

Copyright (C)  Potix Corporation. All Rights Reserved.

-->
<zk xmlns:x="xhtml">
  <label multiline="true">
  1. click button 1 will change color to green and text to "green"
  2. click button 2 will change color to blue and text to "blue"
  </label>
  <x:div id="xdiv" style="color: red"
      textContent="red"/>
  <button id="btn1" label="1. style, 2. textContent" 
      onClick=\'
        xdiv.setStyle("color: green"); 
        xdiv.setDynamicProperty("textContent", "green")\'/>
  <button id="btn2" label="1. textContent, 2. style" 
      onClick=\'
        xdiv.setDynamicProperty("textContent", "blue"); 
        xdiv.setStyle("color: blue");\'/>
</zk>`,
	);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#xdiv").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("red"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("#xdiv").attr("style"))(),
			),
		)
		.contains(ztl.normalizeText("red"), "");
	await t.click(Selector(() => jq(".z-button").first()[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#xdiv").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("green"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("#xdiv").attr("style"))(),
			),
		)
		.contains(ztl.normalizeText("green"), "");
	await t.click(Selector(() => jq(".z-button").last()[0]));
	await ztl.waitResponse(t);
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() =>
					jq("#xdiv").text().replace(/\s/g, " "),
				)(),
			),
		)
		.eql(ztl.normalizeText("blue"));
	await t
		.expect(
			ztl.normalizeText(
				await ClientFunction(() => jq("#xdiv").attr("style"))(),
			),
		)
		.contains(ztl.normalizeText("blue"), "");
});
