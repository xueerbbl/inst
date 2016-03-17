/**
 * @license Copyright (c) 2003-2015, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see LICENSE.md or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here.
	// For complete reference see:
	// http://docs.ckeditor.com/#!/api/CKEDITOR.config

	// The toolbar groups arrangement, optimized for two toolbar rows.
	config.toolbarGroups = [
		{ name: 'clipboard',   groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing',     groups: [ 'find', 'selection', 'spellchecker' ] },
		{ name: 'links' },
		{ name: 'insert' },
		{ name: 'forms' },
		{ name: 'tools' },
		{ name: 'document',	   groups: [ 'mode', 'document', 'doctools' ] },
		{ name: 'others' },
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph',   groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
		{ name: 'styles' },
		{ name: 'colors' },
		{ name: 'about' }
	];

	// Remove some buttons provided by the standard plugins, which are
	// not needed in the Standard(s) toolbar.
	config.removeButtons = 'Underline,Subscript,Superscript';

	// Set the most common block elements.
	config.format_tags = 'p;h1;h2;h3;pre';

	// Simplify the dialog windows.
	config.removeDialogTabs = 'image:advanced;link:advanced';
	config.image_previewText = '欢迎使用大连因斯特管理系统';
	config.filebrowserBrowseUrl = '/resources/editor/ckfinder/ckfinder.html',
	config.filebrowserImageBrowseUrl = '/resources/editor/ckfinder/ckfinder.html?type=Images',
	config.filebrowserFlashBrowseUrl = '/resources/editor/ckfinder/ckfinder.html?type=Flash',
	config.filebrowserUploadUrl = '/resources/editor/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files',
	config.filebrowserImageUploadUrl = '/resources/editor/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images',
	config.filebrowserFlashUploadUrl = '/resources/editor/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash',
	config.filebrowserWindowWidth = '1000',
	config.filebrowserWindowHeight = '700'
};
