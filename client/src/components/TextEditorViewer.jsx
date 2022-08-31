import React from 'react';
import { Viewer } from '@toast-ui/react-editor';
import '@toast-ui/editor/dist/toastui-editor-viewer.css';
import styled from 'styled-components';

const ViewerWrapper = styled.div`
  border: 1px solid red;
`;

const TextEditorViewer = ({ contents }) => {
  return (
    <ViewerWrapper>
      <Viewer initialValue={contents || ''} />
    </ViewerWrapper>
  );
};

export default TextEditorViewer;
