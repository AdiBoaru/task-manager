import React, { useState } from 'react';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';


const App: React.FC = () => {
  const [stompClient, setStompClient] = useState<Stomp.Client | null>(null);
  const [from, setFrom] = useState('');
  const [text, setText] = useState('');

  const connectWebSocket = () => {
    const socket = new SockJS('http://localhost:8080/ws');
    const client = Stomp.over(socket);
    client.connect({}, function(frame) {
      console.log(frame);
      setStompClient(client);
      client.subscribe('/all/application', function(result) {
        show(JSON.parse(result.body));
      });
    });
  };

  const disconnectWebSocket = () => {
    if (stompClient) {
      stompClient.disconnect(() => {
        console.log('WebSocket disconnected');
      });
    }
  };

  const sendMessage = () => {
    if (stompClient) {
      stompClient.send('/app/application', {}, JSON.stringify({ from: from, text: text }));
    }
  };

  const show = (message: any) => {
    console.log('Received:', message);
    // Update UI to display notification
  };

  return (
    <div>
      <div>
        <label htmlFor="from">From:</label>
        <input type="text" id="from" value={from} onChange={(e) => setFrom(e.target.value)} />
      </div>
      <div>
        <label htmlFor="text">Text:</label>
        <input type="text" id="text" value={text} onChange={(e) => setText(e.target.value)} />
      </div>
      <button onClick={connectWebSocket}>Connect WebSocket</button>
      <button onClick={disconnectWebSocket}>Disconnect WebSocket</button>
      <button onClick={sendMessage}>Send Message</button>
    </div>
  );
};
export default App;
