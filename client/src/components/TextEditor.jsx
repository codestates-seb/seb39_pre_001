import React, { useState, useRef } from 'react';
import { Editor, Viewer } from '@toast-ui/react-editor';
import '@toast-ui/editor/dist/toastui-editor.css';
import '@toast-ui/editor/dist/toastui-editor-viewer.css';
import styled from 'styled-components';
import TextEditorViewer from './TextEditorViewer';

const TextEditorWrapper = styled.div`
	width: 678px;
	height: 284px;
	/* border: 1px solid #BABFC4; */
	display: flex;
	flex-direction: column;
`;

const AnswerSubmitButton = styled.button`
	background-color: #0a95ff;
	color: #fff;
	font-size: 13px;
	font-weight: 500;
	padding: 10.4px;
	margin: 20px 2px;
	border: none;
	border-radius: 4px;
	width: 128.91px;
	cursor: pointer;
	:hover {
		background-color: #0074cc;
	}
`;

const TextEditor = () => {
	// input에 작성한 text 가져오기
	const [editor, setEditor] = useState('');
	const editorRef = useRef();

	const onChangeHandler = () => {
		// editorRef.current.getInstance().getHTML()
		// 에디터에 입력한 content 를 md 형식으로 가져오기 --> 나중에 DB 저장시 필요!
		const data = editorRef.current.getInstance().getMarkdown();
		console.log(data);
	};

	// const handleSubmit = (e) => {
	//   e.preventDefault();
	//   setEditor(editorRef.current.getInstance().getMarkdown());
	// };

	return (
		<>
			<TextEditorWrapper>
				<Editor
					initialValue=" "
					previewStyle="tab"
					height="284px"
					initialEditType="markdown"
					useCommandShortcut={false}
					hideModeSwitch={true}
					ref={editorRef}
					onChange={onChangeHandler}
					// toolbar 커스텀
					toolbarItems={[
						['bold', 'italic'],
						['link', 'quote', 'image', 'code', 'codeblock'],
						['ol', 'ul', 'indent', 'outdent'],
					]}
				/>
			</TextEditorWrapper>
			<TextEditorViewer />
			<AnswerSubmitButton>Post Your Answer</AnswerSubmitButton>
		</>
	);
};

export default TextEditor;
