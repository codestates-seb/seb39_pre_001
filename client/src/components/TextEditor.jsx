import React, { useRef, useState } from 'react';
import { Editor } from '@toast-ui/react-editor';
import '@toast-ui/editor/dist/toastui-editor.css';
import styled from 'styled-components';
import ReactMarkdown from 'react-markdown';

const TextEditorWrapper = styled.div`
  /* border: 1px solid #BABFC4; */
  display: flex;
  flex-direction: column;
  .tab-item {
    display: none;
  }
`;

const TextEditor = () => {
  const [content, setContent] = useState('');

  // input에 작성한 text 가져오기
  const editorRef = useRef();

  const onChangeHandler = () => {
    // editorRef.current.getInstance().getHTML()
    // 에디터에 입력한 content 를 md 형식으로 가져오기 --> 나중에 DB 저장시 필요!
    const data = editorRef.current.getInstance().getMarkdown();
    setContent(data);
  };

  return (
    <TextEditorWrapper>
      <Editor
        initialValue=' '
        previewStyle='tab'
        height='auto'
        initialEditType='markdown'
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
      <ReactMarkdown>{content}</ReactMarkdown>
    </TextEditorWrapper>
  );
};

export default TextEditor;
