import Questions from './components/Questions';
import QuestionCreator from './components/QuestionCreator';
import QuestionAnswer from './components/QuestionAnswer';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
function App() {
  return (
    <div className='App'>
      <BrowserRouter>
        <Routes>
          <Route path='/questions' element={<Questions />} />
          <Route path='/questions/ask' element={<QuestionCreator />} />
          <Route path='/questions/:questionId' element={<QuestionAnswer />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
