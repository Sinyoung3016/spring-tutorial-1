import setUpAxios from "./api";
import "./App.css";
import Input from "./component/input";
import Output from "./component/output";

function App() {
  setUpAxios();

  return (
    <div className="App">
      <div
        style={{
          margin: "10px",
          border: "1px solid",
          width: "500px",
          height: "500px",
        }}
      >
        <Input></Input>
        <Output></Output>
      </div>
    </div>
  );
}

export default App;
