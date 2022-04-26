import InboxIcon from '@mui/icons-material/MoveToInbox';
import MailIcon from '@mui/icons-material/Mail';
import StarRateIcon from '@mui/icons-material/StarRate';
import SendIcon from '@mui/icons-material/Send';
import DraftsIcon from '@mui/icons-material/Drafts';
import DeleteIcon from '@mui/icons-material/Delete';
import ReportGmailerrorredIcon from '@mui/icons-material/ReportGmailerrorred';
import Divider from '@mui/material/Divider';

export const upMenu = [
  {
    key: 1,
    icon: <InboxIcon />,
    name: 'Inbox',
    to: '/inbox',
  },
  {
    key: 2,
    icon: <StarRateIcon />,
    name: 'Starred',
    to: '/starred',
  },
  {
    key: 3,
    icon: <SendIcon />,
    name: 'Send email',
    to: '/send',
  },
  {
    key: 4,
    icon: <DraftsIcon />,
    name: 'Drafts',
    to: '/drafts',
  },
];

export const downMenu = [
  {
    key: 6,
    icon: <MailIcon />,
    name: 'All mail',
    to: '/mail',
  },
  {
    key: 7,
    icon: <DeleteIcon />,
    name: 'Trash',
    to: '/mail/trash',
  },
  {
    key: 8,
    icon: <ReportGmailerrorredIcon />,
    name: 'Spam',
    to: '/mail/spam',
  },
];
