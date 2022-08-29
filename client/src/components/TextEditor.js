import React, { useRef } from 'react';
import { Editor } from '@toast-ui/react-editor';
import '@toast-ui/editor/dist/toastui-editor.css';
import styled from 'styled-components';

const TextEditorWrapper = styled.div`
  width: 678px;
  height: 284px;
  /* border: 1px solid #BABFC4; */
  display: flex;
  flex-direction: column;
`;

const TextEditor = () => {
  // input에 작성한 text 가져오기
  const editorRef = useRef();

  const onChangeHandler = () => {
    // editorRef.current.getInstance().getHTML()
    // 에디터에 입력한 content 를 md 형식으로 가져오기 --> 나중에 DB 저장시 필요!
    const data = editorRef.current.getInstance().getMarkdown();
    console.log(data);
  };

  return (
    <TextEditorWrapper>
      <Editor
        initialValue=" "
        previewStyle="vertical"
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
  );
};

export default TextEditor;